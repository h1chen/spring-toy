package cn.h1chen.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源的抽象
 *
 * @author h1chen
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
