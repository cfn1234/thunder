package com.wxadt.wxcep.utlis;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/**
 * https工具类
 *
 * @author caofengnian
 * @Date 2020-07-16
 */
public class HttpsUtils {

  /**
   * 发送HTTPS请求 发微信消息的请求
   *
   * @param requestUrl 请求的URL
   * @return
   * @throws IOException
   * @throws NoSuchProviderException
   * @throws NoSuchAlgorithmException
   * @throws KeyManagementException
   */
  public InputStream httpRequest(String requestUrl) throws Exception {
    URL myUrl = new URL(requestUrl);
    HttpsURLConnection conn = (HttpsURLConnection) myUrl.openConnection();
    // https 工厂
    SSLSocketFactory ssf = createFactory();
    conn.setConnectTimeout(2000);
    conn.setReadTimeout(3000);
    conn.setSSLSocketFactory(ssf);
    conn.setRequestProperty("origin", "www.weixiaojiao.cn");
    conn.setRequestProperty("Host", "cdnfile-10043692.cos.ap-shanghai.myqcloud.com");
    conn.setRequestProperty("User-Agent",
        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36");
    InputStream is = conn.getInputStream();
    conn.disconnect();
    return is;

  }

  /**
   * 创建SSL 工厂
   *
   * @return
   * @throws NoSuchAlgorithmException
   * @throws NoSuchProviderException
   * @throws KeyManagementException
   */
  private SSLSocketFactory createFactory() throws NoSuchAlgorithmException, KeyManagementException {

    TrustManager[] tm = {new MyX509TrustManager()};
    SSLContext sslContext = SSLContext.getInstance("TLSv1");
    sslContext.init(null, tm, new java.security.SecureRandom());
    return sslContext.getSocketFactory();

  }
}