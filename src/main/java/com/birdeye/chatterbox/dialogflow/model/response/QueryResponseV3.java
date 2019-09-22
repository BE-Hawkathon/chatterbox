package com.birdeye.chatterbox.dialogflow.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class QueryResponseV3
{
    private String source;
    private String fulfillmentText;
    private FulfillmentMessages[] fulfillmentMessages;
    private Payload payload;
    private OutputContexts[] outputContexts;
    private FollowupEventInput followupEventInput;


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

            //name
            private String title;

            //identifier
            private String subtitle;
            //url
            private String imageUri;
            private Buttons[] buttons;

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
