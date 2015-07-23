package odushyn.kyivche.publisher.main;


import odushyn.kyivche.publisher.statistics.Statistics;
import odushyn.kyivche.publisher.utils.VK;
import odushyn.kyivche.publisher.utils.VkConnectionParams;

/**
 * Created by Oleksander.Dushyn on 7/20/2015.
 */
public class Main {


    public static void main(String[] argc){


        VkConnectionParams params = new VkConnectionParams("5002202", "hVbAID9O0ELN83zYmoaI", "ad08d664aa790755d72f29e13bd7323b821d8765b7381fe4f72c943708ebc7429fcdb03a7292bf9a834b9");

        VK vkAPI = new VK(params);

        Statistics statistics = new Statistics(vkAPI, "che_kiev", "-70085164");

        statistics.getMostActiveHitchhiker();


    }
}
