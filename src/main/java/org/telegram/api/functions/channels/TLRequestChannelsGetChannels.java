package org.telegram.api.functions.channels;

import org.telegram.api.input.chat.TLAbsInputChannel;
import org.telegram.api.messages.chats.TLMessagesChats;
import org.telegram.tl.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The type TL request channel get channels
 */
public class
TLRequestChannelsGetChannels extends TLMethod<TLMessagesChats> {
    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0xa7f6bbb;

    private TLVector<TLAbsInputChannel> id;

    /**
     * Instantiates a new TL request channel get channels
     */
    public TLRequestChannelsGetChannels() {
        super();
    }

    public int getClassId() {
        return CLASS_ID;
    }

    public TLMessagesChats deserializeResponse(InputStream stream, TLContext context)
            throws IOException {
        final TLObject res = StreamingUtils.readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if ((res instanceof TLMessagesChats)) {
            return (TLMessagesChats) res;
        }
        throw new IOException("Incorrect response type. Expected " + TLMessagesChats.class.getName() +", got: " + res.getClass().getName());
    }

    public TLVector<TLAbsInputChannel> getId() {
        return id;
    }

    public void setId(TLVector<TLAbsInputChannel> id) {
        this.id = id;
    }

    public void serializeBody(OutputStream stream)
            throws IOException {
        StreamingUtils.writeTLVector(this.id, stream);
    }

    public void deserializeBody(InputStream stream, TLContext context)
            throws IOException {
        this.id = (TLVector<TLAbsInputChannel>) StreamingUtils.readTLVector(stream, context);
    }

    public String toString() {
        return "channels.getChannels#a7f6bbb";
    }
}