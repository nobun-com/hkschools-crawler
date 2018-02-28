package com.hkschool.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Component
public class ImageDownloader {

	@Value("${awscredentialsaccesskey}")
	private String awsCredentialsAccessKey = "";

	@Value("${awscredentialssecretkey}")
	private String awsCredentialsSecretKey = "";

	@Value("${awscredentialsbucketname}")
	private String awsCredentialsBucketName = "";

	public String saveImage(String imageUrl, String dir) throws IOException {

		String uuid = UUID.randomUUID().toString();

		URL sourceImageUrl = new URL(imageUrl);
		InputStream is = sourceImageUrl.openStream();

		File file = File.createTempFile(uuid, ".png");
		String imagePath = "hkschool/" + dir + "/" + uuid + ".png";
		OutputStream os = new FileOutputStream(file);
		
		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
		AWSCredentials credentials = new BasicAWSCredentials(awsCredentialsAccessKey, awsCredentialsSecretKey);
		AmazonS3 s3client = new AmazonS3Client(credentials);
		s3client.putObject(new PutObjectRequest(awsCredentialsBucketName, imagePath, file).withCannedAcl(CannedAccessControlList.PublicRead));
		URL url = s3client.getUrl(awsCredentialsBucketName, imagePath);
		return url.toExternalForm();
	}

}