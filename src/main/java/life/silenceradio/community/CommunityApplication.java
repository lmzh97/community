package life.silenceradio.community;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@MapperScan(basePackages = "life.silenceradio.community.mapper")
public class CommunityApplication {
 public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class, args);
    }

}
