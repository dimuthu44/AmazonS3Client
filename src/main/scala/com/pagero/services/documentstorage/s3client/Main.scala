package com.pagero.services.documentstorage.s3client

import java.io.FileNotFoundException
import java.net.URI

import software.amazon.awssdk.auth.credentials.{AwsBasicCredentials, AwsCredentialsProvider, AwsSessionCredentials, StaticCredentialsProvider}
import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.{PutObjectRequest, S3Exception}


object Main extends App {

  // Initialize S3 SDK v2
  val region = Region.EU_CENTRAL_1

  val s3Credential = AwsSessionCredentials.create("dimuthukey", "dimuthusecret", "token")
  val basicCredentials: AwsBasicCredentials = AwsBasicCredentials.create("dimuthukey", "dimuthusecret")
  val credentialsProvider : AwsCredentialsProvider = StaticCredentialsProvider.create(basicCredentials)

  val s3Client: S3Client = S3Client.builder.
    region(region).
    endpointOverride(new URI("http://localhost:9000")).
    credentialsProvider(credentialsProvider).
    build()

  // test put object
  putS3Object(s3Client, "bucket001", "key", "/")
  // end test


  def putS3Object(s3: S3Client, bucketName: String, objectKey: String, objectPath: String): String = {
    val bytes = "Test".getBytes

    try { //Put a file into the bucket
      val response = s3.putObject(PutObjectRequest.builder.
        bucket(bucketName).
        key(objectKey).
        build(),
      RequestBody.fromBytes(bytes))

      return response.eTag
    } catch {
      case e@(_: S3Exception | _: FileNotFoundException) =>
        System.err.println(e)
    }
    ""
  }
}
