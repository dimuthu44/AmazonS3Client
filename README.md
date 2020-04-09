How to run
1. docker pull minio/minio
2. Run the pulled image 
docker run -p 9000:9000 --env MINIO_ACCESS_KEY="dimuthukey" --env MINIO_SECRET_KEY="dimuthusecret"  minio/minio server /data

3. Log into minio using http://127.0.0.1:9000 and create a test bucet "bucket001" 
