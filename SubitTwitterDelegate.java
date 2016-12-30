package org.inexoos.procesos.pruebaTwitter;


import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import twitter4j.conf.ConfigurationBuilder;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

public class SubirTwitterDelegate implements JavaDelegate {

  private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

  public void execute(DelegateExecution execution) throws Exception {
    LOGGER.info("Subiendo a twitter '"+execution.getVariable("texto").toString()+"'");
    ConfigurationBuilder config =
        new ConfigurationBuilder()
               .setOAuthConsumerKey("XXXXXXX")
               .setOAuthConsumerSecret("XXXXXXX")
               .setOAuthAccessToken("xxxxx")
               .setOAuthAccessTokenSecret("xxxxx")
               .setJSONStoreEnabled(true);

     // create the twitter stream factory with the config
    TwitterFactory fact = new TwitterFactory(config.build());
    Twitter twitterStream;
    // get an instance of twitter stream
    twitterStream = fact.getInstance();
    twitterStream.updateStatus(execution.getVariable("texto").toString());
  }

}
