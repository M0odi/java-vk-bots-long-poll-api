package api.longpoll.bots.methods.impl.stories;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.additional.StoriesFeedBlock;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.response.GenericResponse;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>stories.get</b> method.
 * <p>
 * Returns stories available for current user.
 *
 * @see <a href="https://vk.com/dev/stories.get">https://vk.com/dev/stories.get</a>
 */
public class Get extends AuthorizedVkApiMethod<Get.Response> {
    public Get(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("stories.get");
    }

    @Override
    protected Class<Response> getResultType() {
        return Response.class;
    }

    public Get setOwnerId(int ownerId) {
        addParam("owner_id", ownerId);
        return this;
    }

    public Get setExtended(boolean extended) {
        addParam("extended", new BoolInt(extended));
        return this;
    }

    public Get setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public Get setFields(List<String> fields) {
        addParam("fields", fields);
        return this;
    }

    /**
     * Response to <b>stories.get</b>
     */
    public static class Response extends GenericResponse<VkList<StoriesFeedBlock>> {
    }
}
