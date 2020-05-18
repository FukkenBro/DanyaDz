
//        Изменить поле params со String на HashMap
//        Добавить метод withParams(HashMap params), который добавляет параметры
//        Обновить уже существующие методы
//        Обновить метод билд с учетом HashMap


import java.util.HashMap;
import java.util.Map;

public class MyUrl {

    private String protocol;
    private String domain;
    private String port;
    private String path;
    private HashMap<String, String> params = new HashMap<String, String>();

    public MyUrl() {
    }

    public MyUrl(String protocol, String domain, String port, String path, HashMap<String, String> params) {
        this.protocol = protocol;
        this.domain = domain;
        this.port = port;
        this.path = path;
        this.params = params;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getDomain() {
        return domain;
    }

    public String getPort() {
        return port;
    }

    public String getPath() {
        return path;
    }

    public HashMap<String, String> getParams() {
        return params;
    }

    public static boolean isBlank(HashMap<String, String> params) {
        boolean result = false;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (isBlank(entry.getValue()) || isBlank(entry.getValue())) {
                result = true;
            }
        }
        return result;
    }

    public static boolean isBlank(String string) {
        boolean result = false;
        if (string.equals(null) || string.equals("") || string.matches("^\\s*$")) {
            result = true;
        }
        return result;
    }

    public static class Builder {

        private MyUrl url = new MyUrl();

        public Builder withProtocol(String protocol) {
            url.protocol = protocol;
            return this;
        }

        public Builder withDomain(String domain) {
            url.domain = domain;
            return this;
        }

        public Builder withPort(String port) {
            url.port = port;
            return this;
        }

        public Builder withPath(String path) {
            url.path = path;
            return this;
        }

        public Builder withParams(String key, String value) {
            url.params.put(key, value);
            return this;
        }

        public String build() {
            StringBuilder u = new StringBuilder("");
            if (url.protocol != null && !url.protocol.isEmpty()) {
                u.append(url.protocol);

                if (!url.protocol.endsWith("://")) {
                    u.append("://");
                }
            }
            u.append("://");

            if (url.port != null && !isBlank(url.port)) {
                if (url.port.startsWith(":")) {
                    u.append(":");
                }
                u.append(url.port);
            }

            if (url.domain != null && !isBlank(url.domain)) {
                u.append(url.domain);
            }

            if (url.path != null && !isBlank(url.path)) {
                if (!url.path.startsWith("/")) {
                    u.append("/");
                }
                u.append(url.path);
            }

            if (url.params != null && !isBlank(url.params)) {
                for (Map.Entry<String, String> entry : url.params.entrySet()) {
                    if (!entry.getKey().startsWith("?")) {
                        u.append("?");
                    }
                    u.append(entry.getKey() + "=" + entry.getValue());
                }
            }
            return u.toString();
        }


    }
}
