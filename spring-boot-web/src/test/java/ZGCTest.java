import java.util.ArrayList;
import java.util.List;

/**
 * @description: zgc测试
 * @author: wangguijun1
 * @create: 2020-09-21 10:11
 **/

public class ZGCTest {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        while (true) {
            byte[] bytes = new byte[1024 * 4];
            list.add(bytes);
        }

    }
}
