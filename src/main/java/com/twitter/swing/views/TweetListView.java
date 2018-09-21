package com.twitter.swing.views;

import com.twitter.swing.utils.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;


public class TweetListView {
    private static final Logger LOGGER = LoggerFactory.getLogger(TweetListView.class);
    private JPanel mainPanel;
    private JScrollPane tweetScrollPane;
    private JPanel tweetPanel;

    public TweetListView() {
        JFrame frame = new JFrame("Tweets");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        tweetPanel.setLayout(new BoxLayout(this.tweetPanel, BoxLayout.Y_AXIS));
        tweetPanel.add(new JLabel("Tweets about Javascript"));
    }

    public void addTweet(URL profileURL, String text) {
        tweetPanel.add(Box.createVerticalStrut(10), 1);

        JLabel tweet = new JLabel(text);

        try {
            BufferedImage image = ImageIO.read(profileURL);
            tweet.setIcon(new ImageIcon(ImageUtil.makeRoundedCorner(image, 100)));
        } catch (IOException e) {
            LOGGER.error("Error creating image: ", e);
        }

        tweet.setIconTextGap(10);

        tweetPanel.add(tweet, 2);

        tweetPanel.revalidate();
        tweetPanel.repaint();
    }
}
