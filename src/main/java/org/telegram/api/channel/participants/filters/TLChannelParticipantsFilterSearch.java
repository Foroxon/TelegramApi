package org.telegram.api.channel.participants.filters;

import org.telegram.tl.StreamingUtils;
import org.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TLChannelParticipantsFilterSearch extends TLAbsChannelParticipantsFilter {
    public static final int CLASS_ID = 0x656ac4b;

    private String q;

    public TLChannelParticipantsFilterSearch() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeTLString(q, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        this.q = StreamingUtils.readTLString(stream);
    }

    @Override
    public String toString() {
        return "channel.participants.filters.TLChannelParticipantsSearch#656ac4b";
    }
}
