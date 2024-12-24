package buptworker.service;

import buptworker.entity.User_pairs;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserRecommendService {
    // 假设文件存储在本地路径 "E:\\BigDataProject\\Financial_analysis\\financial-backend\src\\user_pairs.txt"
    private static final String FILE_PATH = "E:\\BigDataProject\\Financial_analysis\\financial-backend\\src\\user_pairs.txt";








    public List<String> getRecommendUserName(String userId) throws IOException {
        List<String> recommendUserName = new ArrayList<>();

        List<String> user_pairs_string = readFile();
        List<User_pairs> user_pairs = new ArrayList<>();

        for (String s : user_pairs_string) {
            String[] user_pairs_string_array = s.split(",");
            User_pairs temp_user_pairs = new User_pairs(user_pairs_string_array[0], user_pairs_string_array[1]);
            user_pairs.add(temp_user_pairs);
        }
        List<String> res = new ArrayList<>();
        for (User_pairs userPair : user_pairs) {
            if (Objects.equals(userPair.getUser_left(), userId)) {
                res.add(userPair.getUser_right());
            }
        }

        List<String> ress = new ArrayList<>();
        ress.add(res.get(0));
        ress.add(res.get(1));
        return ress;
    }


    /**
     * 读取文件内容并返回为字符串列表
     */
    public List<String> readFile() throws IOException {
        Path path = Paths.get(FILE_PATH);
        // 读取文件内容，按行返回
        return Files.readAllLines(path);
    }

    /**
     * 读取文件内容并返回为单个字符串
     */
    public String readFileAsString() throws IOException {
        Path path = Paths.get(FILE_PATH);
        // 读取文件内容，返回整个文件内容作为一个字符串
        return new String(Files.readAllBytes(path));
    }
}
