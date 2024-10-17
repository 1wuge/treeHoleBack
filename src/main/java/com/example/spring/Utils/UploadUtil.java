package com.example.spring.Utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public class UploadUtil {
    //阿里域名
    public static final String AIL_DOMAIN="";

    public static String uploadImage(MultipartFile file) throws IOException {
        String originalName=file.getOriginalFilename();
        int index=originalName.lastIndexOf(".");
        String uuid= UUID.randomUUID().toString().replace("-","");
        String imgName="";
        if(index!=-1)
        {
            imgName=uuid+originalName.substring(index);
        }
        else{
             imgName=uuid;
        }
        //地域节点
        String endpoint="";
        String accessKeyId="";
        String accessKeySecret="";
        OSS ossClient=new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
        ossClient.putObject(
                "treeholess",
                  imgName,
                  file.getInputStream()
        );
        ossClient.shutdown();
        System.out.println(AIL_DOMAIN+imgName);
        return AIL_DOMAIN+imgName;
    }

}
