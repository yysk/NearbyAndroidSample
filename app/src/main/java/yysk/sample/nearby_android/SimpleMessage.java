package yysk.sample.nearby_android;

import com.google.android.gms.nearby.messages.Message;
import com.google.gson.Gson;

import java.nio.charset.Charset;

public class SimpleMessage {
    private static final Gson gson = new Gson();

    private final String mId;

    public static Message newMessage(String id) {
        SimpleMessage simpleMessage = new SimpleMessage(id);
        return new Message(gson.toJson(simpleMessage).toString().getBytes(Charset.forName("UTF-8")));
    }

    public static SimpleMessage fromMessage(Message message) {
        String str = new String(message.getContent()).trim();
        return gson.fromJson(
                (new String(str.getBytes(Charset.forName("UTF-8")))),
                SimpleMessage.class);
    }

    private SimpleMessage(String id) {
        this.mId = id;
    }

    public String getId() {
        return mId;
    }
}