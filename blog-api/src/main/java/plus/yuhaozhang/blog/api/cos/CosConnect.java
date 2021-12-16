package plus.yuhaozhang.blog.api.cos;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.Bucket;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import plus.yuhaozhang.blog.constant.Constant;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * @author Yuh Z
 * @date 12/15/21
 */
public class CosConnect {
    private COSClient cosClient;
    public COSClient open() {

        // 1 初始化用户身份信息（secretId, secretKey）。

        COSCredentials cred = new BasicCOSCredentials(Constant.secretId, Constant.secretKey);
        Region region = new Region(Constant.region);
        ClientConfig clientConfig = new ClientConfig(region);
        clientConfig.setHttpProtocol(HttpProtocol.https);
        clientConfig.setSocketTimeout(30*1000);
        clientConfig.setConnectionTimeout(30*1000);
        // 3 生成 cos 客户端。
        cosClient = new COSClient(cred, clientConfig);
        return cosClient;
    }
    public void close(){
        cosClient.shutdown();
    }
    public URL save(String fileName, File file) throws IOException {
        PutObjectRequest putObjectRequest = new PutObjectRequest(Constant.bucketName, Constant.file + fileName, file);
        cosClient.putObject(putObjectRequest);
        Date expirationDate = new Date(System.currentTimeMillis() + 1000L*24L*60L * 60L * 1000L);
        URL url =cosClient.generatePresignedUrl(Constant.bucketName,Constant.file + fileName,expirationDate, HttpMethodName.GET);
        return url;
    }

    public static void main(String[] args) throws IOException {
        CosConnect cosConnect = new CosConnect();
        cosConnect.open();
        URL test = cosConnect.save("test", null);
        System.out.println(test);
        cosConnect.close();
    }
}
