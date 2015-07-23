package odushyn.kyivche.publisher.main;


import odushyn.kyivche.publisher.statistics.Statistics;
import odushyn.kyivche.publisher.utils.VK;
import odushyn.kyivche.publisher.utils.VkConnectionParams;

/**
 * Created by Oleksander.Dushyn on 7/20/2015.
 */
public class Main {


    public static void main(String[] argc){


        VkConnectionParams params = new VkConnectionParams("5002202", "hVbAID9O0ELN83zYmoaI", "4070ad9125b560318ddb284ce5323dcf2c53a7afd32eee8553dbbcd467eda514703dfcb6d9fc2634ed0ec");

        VK vkAPI = new VK(params);

        Statistics statistics = new Statistics(vkAPI, "che_kiev");

        statistics.getMostActiveHitchhiker();


    }
}
