package plus.yuhaozhang.blog.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import plus.yuhaozhang.blog.api.cos.CosConnect;
import plus.yuhaozhang.blog.vo.Result;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.UUID;

/**
 * @author Yuh Z
 * @date 12/15/21
 */
@RestController
@RequestMapping("upload")
public class UploadController {
    private CosConnect cosConnect;
    @PostMapping
    public Result uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString()+"."+ StringUtils.substringAfterLast(originalFilename,".");
        File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+fileName);
        file.transferTo(convFile);

        cosConnect = new CosConnect();
        cosConnect.open();
        URL url = cosConnect.save(fileName,convFile);
        cosConnect.close();
        return Result.success(url);
    }
}
