package cn.tzq0301.webserver.util;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author TZQ
 * @Description TODO
 */
public class TzqFileUtils {
    public static byte[] classPathResourceToByteArray(String path) {
        return classPathResourceToByteArray(new ClassPathResource(path));
    }

    public static byte[] classPathResourceToByteArray(ClassPathResource resource) {
        InputStream inputStream = null;
        byte[] bytes = null;
        try {
            inputStream = resource.getInputStream();
            bytes = IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
