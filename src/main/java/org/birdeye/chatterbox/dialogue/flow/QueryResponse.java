package org.birdeye.chatterbox.dialogue.flow;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class QueryResponse
{
    private String fulfillmentText;
    private FulfillmentMessages[] fulfillmentMessages;
    private OutputContexts[] outputContexts;
    private FollowupEventInput followupEventInput;
    private Payload payload;
    private String source;


    @Getter
    @Setter
    @ToString
    public static class FulfillmentMessages
    {

        private Card card;

        @Getter
        @Setter
        @ToString
        public static class Card
        {

            private String imageUri;
            private Buttons[] buttons;
            private String subtitle;
            private String title;

            @Getter
            @Setter
            @ToString
            public static class Buttons
            {

                private String postback;
                private String text;
            }
        }
    }

    @Getter
    @Setter
    @ToString
    public static class OutputContexts
    {

        private String name;
        private String lifespanCount;
        private Parameters parameters;
    }

    @Getter
    @Setter
    @ToString
    public static class FollowupEventInput
    {
        private String name;
        private String languageCode;
        private Parameters parameters;

    }

    @Getter
    @Setter
    @ToString
    public static class Payload
    {

        private Facebook facebook;
        private Slack slack;
        private Google google;

        @Getter
        @Setter
        @ToString
        public static class Facebook
        {
            private String text;
        }

        @Getter
        @Setter
        @ToString
        public static class Slack
        {
            private String text;
        }

        @Getter
        @Setter
        @ToString
        public static class Google
        {

            private RichResponse richResponse;
            private String expectUserResponse;

            @Getter
            @Setter
            @ToString
            public static class RichResponse
            {
                private Items[] items;

                @Getter
                @Setter
                @ToString
                public static class Items
                {
                    private SimpleResponse simpleResponse;

                    @Getter
                    @Setter
                    @ToString
                    public static class SimpleResponse
                    {
                        private String textToSpeech;
                    }
                }
            }
        }
    }

    @Getter
    @Setter
    @ToString
    public static class Parameters
    {
        private String param;
    }

}
