package odushyn.kyivche.publisher.main;


import odushyn.kyivche.publisher.statistics.chekiev.Statistics;
import odushyn.kyivche.publisher.utils.VK;
import odushyn.kyivche.publisher.utils.VkConnectionParams;

/**
 * Created by Oleksander.Dushyn on 7/20/2015.
 */
public class Main {


    public static void main(String[] argc){

        //https://oauth.vk.com/authorize?client_id=5002202&scope=friends,wall&redirect_uri=https://oauth.vk.com/blank.html&display=page&v=5.34&response_type=token
        VkConnectionParams params = new VkConnectionParams("5002202", "hVbAID9O0ELN83zYmoaI", "ba496c4c68b3ca2f7c2ffdca46f6bc7216434f2301c143d2506ada68f19cd6cea7cb1e0cfc4d03893add0");

        VK vkAPI = new VK(params);

        Statistics statistics = new Statistics(vkAPI, "che_kiev", "-70085164");

        statistics.getMostActiveHitchhiker();


    }
}
