# Instagram Scraper API for Java

[![Latest release](https://img.shields.io/github/v/tag/jsonscraper/instagram-api-java?label=release&style=flat-square)](https://github.com/jsonscraper/instagram-api-java/tags)
[![Java requirements](https://img.shields.io/badge/Java-17%2B-ED8B00?logo=openjdk&logoColor=white&style=flat-square)](#quick-start)
[![Last commit](https://img.shields.io/github/last-commit/jsonscraper/instagram-api-java?style=flat-square)](https://github.com/jsonscraper/instagram-api-java/commits)
[![MIT license](https://img.shields.io/github/license/jsonscraper/instagram-api-java?style=flat-square)](LICENSE)
[![Run in Postman](https://run.pstmn.io/button.svg)](https://www.postman.com/jsonscraper/workspace/jsonscraper/collection/52903714-fe84d353-0a19-431f-a39d-1c2640d96fb0)

A small, configurable client with named methods and ready-to-run examples. Supports **97 Instagram Scraper API methods**.

**Package:** `com.jsonscraper:instagram-api` · **[Methods](#main-methods)** · **[Examples](#ready-to-run-examples)** · **[Documentation](docs/guide.md)**

![Quick start: API key, installation, request, JSON](docs/quickstart.svg)

## Quick start

**1. Get your key** from the [Instagram API product page](https://jsonscraper.com/services/ig-scraper-api?utm_source=github&utm_medium=sdk&utm_campaign=instagram-api-java&utm_content=readme) and set it on your server:

```sh
export JSONSCRAPER_INSTAGRAM_LICENSE_KEY='your-license-key'
```

**2. Install the package:**

```sh
git clone https://github.com/jsonscraper/instagram-api-java.git
cd instagram-api-java
mvn install
```

**3. Make a request:**

```java
import com.jsonscraper.instagram.Instagram;
import java.util.Map;
import java.nio.charset.StandardCharsets;

public class Example {
 public static void main(String[] args) throws Exception {
  var client = new Instagram(System.getenv("JSONSCRAPER_INSTAGRAM_LICENSE_KEY"));
  var response = client.v1_user_by_username(Map.of("username", "apple", "cache_timeout", 60));
  System.out.println(new String(response.body(), StandardCharsets.UTF_8));
 }
}
```

The API payload is in `ig`. Live calls require a valid API license and may consume quota. [Response examples and status handling](docs/responses.md).

## Main methods

97 methods are available. Common starting points:

| What you need | Method |
| --- | --- |
| Read a profile | `v1_user_by_username()` |
| Read a profile by ID | `v1_user_by_id()` |
| List profile posts | `v1_user_medias_chunk()` |
| Read a post or reel | `v1_media_by_code()` |
| Read comments | `v1_media_comments_chunk()` |
| Search profiles | `v1_search_users()` |

[All methods and parameters →](docs/endpoints.md)

## Ready-to-run examples

- [Read a profile](examples/endpoints/V1UserByUsername.java).
- [Read a post or reel](examples/endpoints/V1MediaByCode.java).
- [Read comments](examples/endpoints/V1MediaCommentsChunk.java).
- [Search users](examples/endpoints/V1SearchUsers.java).
- [List profile posts](examples/endpoints/V1UserMediasChunk.java).

Each example includes command-line parameters, key setup, timeouts, error handling and response output. Run it with `--help` first; this makes no API request.

**[Browse all 97 complete examples](examples/README.md)** · **[Full method and parameter reference](docs/endpoints.md)**

## Configuration

Requests use a 30-second timeout by default. Configure caching and retries to fit your application's request budget. Keys are read from your server environment; redirects are disabled.

[Configuration options, HTTP errors, caching and pagination](docs/configuration.md) · [Full integration guide](docs/guide.md)

## Access, pricing and support

The SDK source is **MIT-licensed**. Hosted API access requires a separate Instagram license. Check [current plans and get access](https://jsonscraper.com/services/ig-scraper-api?utm_source=github&utm_medium=sdk&utm_campaign=instagram-api-java&utm_content=readme).

[Service support](https://jsonscraper.com/contacts?utm_source=github&utm_medium=sdk&utm_campaign=instagram-api-java&utm_content=support) · [SDK issues](https://github.com/jsonscraper/instagram-api-java/issues) · [Changelog](CHANGELOG.md) · [MIT license](LICENSE)

## Development

```sh
python3 tests/contract.py
```

Tests use a local/mock server and require no API key. A [GitHub Actions template](docs/github-actions.yml) is available for optional automation.

The SDK has no installation or usage telemetry. README links use campaign parameters for website referral analytics. jsonscraper is independent and is not affiliated with Instagram or Meta.
