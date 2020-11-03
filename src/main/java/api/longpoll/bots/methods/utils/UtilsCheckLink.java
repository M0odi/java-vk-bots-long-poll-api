package api.longpoll.bots.methods.utils;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.utils.UtilsCheckLinkResponse;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>utils.checkLink</b> method.
 *
 * @see <a href="https://vk.com/dev/utils.checkLink">https://vk.com/dev/utils.checkLink</a>
 */
public class UtilsCheckLink extends GetMethod<GenericResult<UtilsCheckLinkResponse>> {
    /**
     * Link to check (e.g., http://google.com).
     */
    private String url;

    public UtilsCheckLink(LongPollBot bot) {
        super(bot);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getApi() {
        return VkApi.getInstance().utilsCheckLink();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected JsonToPojoConverter<GenericResult<UtilsCheckLinkResponse>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<UtilsCheckLinkResponse>>(){}.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(keyVal("url", url));
    }

    public String getUrl() {
        return url;
    }

    public UtilsCheckLink setUrl(String url) {
        this.url = url;
        return this;
    }
}
