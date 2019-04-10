package academy.learnprogramming.console;

import academy.learnprogramming.config.AppConfig;
import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import academy.learnprogramming.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
    private static final Logger log = LoggerFactory.getLogger((Main.class));

    public static void main(String[] args)
    {
        log.info("Guess the number game");

        //create context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //get numberGenerator bean from context
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        int number = numberGenerator.next();
        log.info("number = {}", number);

        //get game bean from context
        Game game = context.getBean(Game.class);

        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info(messageGenerator.getMainMessage());
        log.info(messageGenerator.getResultMessage());

        context.close();
    }
}
