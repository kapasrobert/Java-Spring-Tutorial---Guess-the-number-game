package academy.learnprogramming.config;

import academy.learnprogramming.Annotations.GuessCount;
import academy.learnprogramming.Annotations.MaxNumber;
import academy.learnprogramming.Annotations.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
@ComponentScan(basePackages = "academy.learnprogramming")
public class GameConfig
{
    @Value("${game.maxNumber:100}")
    private int maxNumber;

    @Value("${game.guessCount:10}")
    private int guessCount;

    @Value("${game.minNumber:0}")
    private int minNumber;

    @Bean
    @MaxNumber
    public int maxNumber()
    {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount()
    {
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber()
    {
        return minNumber;
    }
}
