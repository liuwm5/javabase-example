package niotest;

import junit.framework.TestCase;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by liuweimin on 16/5/23.
 */
public class NioTest extends TestCase {
    //IO读取测试
    public void testIO() {
        InputStream inputStream = null;
        try {//读取文件
            inputStream = new BufferedInputStream(new FileInputStream("/Users/liuweimin/Desktop/Ticket/TicketBrushSystem/README.md"));
            //建立缓冲区
            byte[] buf = new byte[1024];
            int bytesRead = inputStream.read(buf);
            while (bytesRead != -1) {//判断是否还能读到数据，读到就继续
                for (int i = 0; i < bytesRead; i++) {
                    System.out.println((char) buf[i]);
                    bytesRead = inputStream.read();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                ;
            }
        }
    }

    //NIO测试
    public void testNIO() {
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("/Users/liuweimin/Desktop/Ticket/TicketBrushSystem/README.md", "rw");

            FileChannel fileChannel = aFile.getChannel();//获取通道
            ByteBuffer buffer = ByteBuffer.allocate(1024);//设置缓冲区
            int bytesRead = fileChannel.read(buffer);//写入数据到缓冲区
            System.out.print(bytesRead);
            while (bytesRead != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());//从缓冲区获取数据
                }
                buffer.compact();//缓冲区清空 还有个方法 clear
                bytesRead = fileChannel.read(buffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (aFile != null) {
                    aFile.close();
                }
            } catch (Exception e) {

            }
        }

    }

    /**
     * NIO 服务端测试
     */
    public void testServerSocket() {
        ServerSocketChannel serverSocketChannel = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();//打开通道
            serverSocketChannel.socket().bind(new InetSocketAddress(9999));
            serverSocketChannel.configureBlocking(false);//设置成非阻塞
            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();//监听新进来的连接
                //do something
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocketChannel != null) {
                try {
                    serverSocketChannel.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
