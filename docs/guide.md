# Instagram Scraper API for Java

[![Latest release](https://img.shields.io/github/v/tag/jsonscraper/instagram-api-java?label=release&style=flat-square)](https://github.com/jsonscraper/instagram-api-java/tags)
[![Java requirements](https://img.shields.io/badge/Java-17%2B-ED8B00?logo=openjdk&logoColor=white&style=flat-square)](#1-install)
[![Last commit](https://img.shields.io/github/last-commit/jsonscraper/instagram-api-java?style=flat-square)](https://github.com/jsonscraper/instagram-api-java/commits)
[![MIT license](https://img.shields.io/github/license/jsonscraper/instagram-api-java?style=flat-square)](../LICENSE)

[![Run in Postman](https://run.pstmn.io/button.svg)](https://www.postman.com/jsonscraper/workspace/jsonscraper/collection/52903714-fe84d353-0a19-431f-a39d-1c2640d96fb0)

Official Java client for the [jsonscraper Instagram Scraper API](https://jsonscraper.com/services/ig-scraper-api?utm_source=github&utm_medium=sdk&utm_campaign=instagram-api-java&utm_content=readme). **97 documented GET routes**, simple installation, configurable requests, working examples, and responses ready for your application.

<picture>
  <source media="(max-width: 640px) and (prefers-color-scheme: dark)" srcset="quickstart-mobile-dark.svg">
  <source media="(max-width: 640px)" srcset="quickstart-mobile.svg">
  <source media="(prefers-color-scheme: dark)" srcset="quickstart-dark.svg">
  <img src="quickstart.svg" alt="Quick start: API key, setup, first request, JSON response" width="880">
</picture>

**[Get an API key](https://jsonscraper.com/services/ig-scraper-api?utm_source=github&utm_medium=sdk&utm_campaign=instagram-api-java&utm_content=get_access) · [Current pricing](https://jsonscraper.com/services/ig-scraper-api?utm_source=github&utm_medium=sdk&utm_campaign=instagram-api-java&utm_content=pricing#pricing) · [Endpoint reference](endpoints.md) · [Runnable examples](../examples) · [Postman](https://www.postman.com/jsonscraper/workspace/jsonscraper/collection/52903714-fe84d353-0a19-431f-a39d-1c2640d96fb0)**

## Navigation

- [What you can build](#what-you-can-build)
- [Installation](#1-install)
- [License key and access](#2-get-api-access)
- [First request](#3-make-your-first-request)
- [Available methods](#available-methods)
- [Request examples](#more-request-examples)
- [Complete example catalogue](#complete-request-example-catalogue)
- [Endpoint reference](endpoints.md)
- [Configuration](#configuration)
- [Errors, pagination and caching](#errors-pagination-and-caching)
- [FAQ](#faq)
- [Development and releases](#development-and-releases)
- [Privacy](#privacy)

## What you can build

Read public profiles; retrieve media, reels and comments; explore hashtag/location/search routes; build analytics, monitoring and data integrations.

This repository contains the **Instagram SDK only**. It calls the hosted jsonscraper API; you do not need to maintain browser automation, platform sessions or a scraping server.

## 1. Install

Requirements: **Java 17+ and Maven**.

```sh
git clone https://github.com/jsonscraper/instagram-api-java.git
cd instagram-api-java
mvn install
```

After `mvn install`, add `com.jsonscraper:instagram-api:0.1.1` to your application dependencies. This version installs locally; it is not yet published to Maven Central.

To develop from a checkout, clone this repository and install its dependencies using the package manager for this SDK.

## 2. Get API access

The SDK source uses the **MIT license**. Hosted API usage requires a separate **Instagram API license** with its own quota and validity period.

1. Open the [Instagram product page](https://jsonscraper.com/services/ig-scraper-api?utm_source=github&utm_medium=sdk&utm_campaign=instagram-api-java&utm_content=onboarding).
2. Check the current plans and follow **Get Access** to obtain your license key.
3. Save the key on your server as an environment variable:

```sh
export JSONSCRAPER_INSTAGRAM_LICENSE_KEY='your-license-key'
```

Current prices and limits are linked from the product page rather than copied into this README. That keeps the purchase information current. Do not commit your key or put it in browser/mobile frontend code.

## 3. Make your first request

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

**[Open the runnable version](../examples/Example.java)**. The example uses a public account and a short server-side cache. You can replace the account with one relevant to your project. A licensed live request may consume quota.

The profile response follows this shape (shortened; fields can be absent or null):

```json
{
  "status": "ok",
  "ig": {
    "pk": "5821462185",
    "username": "apple",
    "is_private": false,
    "is_verified": true
  }
}
```

**[Response handling guide](responses.md)** explains the envelope, application errors and identifiers. Profile responses were verified against the live API on 2026-10-25.

## Available methods

97 named API methods are available. Start with these commonly used requests, then open the [complete method reference](endpoints.md) for every method and its parameters.

| Use case | SDK method | Query parameters |
| --- | --- | --- |
| Get user info by username (by ID is faster) | `v1_user_by_username()` | `username`, `cache_timeout` |
| Get user info by ID | `v1_user_by_id()` | `id`, `cache_timeout` |
| Get posts (chunked) | `v1_user_medias_chunk()` | `user_id`, `end_cursor`, `cache_timeout` |
| Get user stories by ID | `v1_user_stories()` | `user_id`, `amount`, `force`, `cache_timeout` |
| Get media info by shortcode | `v1_media_by_code()` | `code`, `cache_timeout` |
| Get media comments (chunked) | `v1_media_comments_chunk()` | `id`, `min_id`, `max_id`, `can_support_threading`, `cache_timeout` |
| Search users | `v1_search_users()` | `query`, `cache_timeout` |
| Search hashtags | `v1_search_hashtags()` | `query`, `cache_timeout` |

Each method is documented with a [complete runnable example](../examples/README.md). The transport preserves the full response envelope, including application status, payload and optional quota metadata.

## Find the request you need

The [endpoint reference](endpoints.md) lists every named SDK method, exact API path, query parameter and purpose. The [Postman collection](https://www.postman.com/jsonscraper/workspace/jsonscraper/collection/52903714-fe84d353-0a19-431f-a39d-1c2640d96fb0) contains current descriptions, parameter examples and endpoint groups.

Use the generic request method for newly added routes without waiting for an SDK release. Parameter names remain identical to Postman. For example, cache controls are always `cache_timeout`; platform IDs are passed as strings.

## More request examples

- [Read a media item](../examples/Media.java) — `GET /v1/media/by/code`.
- [Search public users](../examples/Search.java) — `GET /v1/search/users`.
- [Read a page of user media](../examples/Feed.java) — `GET /v1/user/medias/chunk`.

These examples make one request each. They never loop automatically through your quota. For feed pagination, inspect the returned cursor and `has_more`, then pass the cursor back to the same endpoint.

## Complete request example catalogue

Every link opens a full program with parameters, authentication, timeout, errors and output handling. **[Running the examples](../examples/README.md)** explains the commands.

<details>
<summary>User · 33 examples</summary>

- [Get user info by ID](../examples/endpoints/V1UserById.java) — `GET /v1/user/by/id`.
- [Get user info by username (by ID is faster)](../examples/endpoints/V1UserByUsername.java) — `GET /v1/user/by/username`.
- [Get user info by URL (by ID is faster)](../examples/endpoints/V1UserByUrl.java) — `GET /v1/user/by/url`.
- [Get info about user by ID](../examples/endpoints/V1UserAbout.java) — `GET /v1/user/about`.
- [Get posts (chunked)](../examples/endpoints/V1UserMediasChunk.java) — `GET /v1/user/medias/chunk`.
- [Get pinned posts](../examples/endpoints/V1UserMediasPinned.java) — `GET /v1/user/medias/pinned`.
- [Get reels (chunked)](../examples/endpoints/V1UserClipsChunk.java) — `GET /v1/user/clips/chunk`.
- [Get tagged (mentions) posts](../examples/endpoints/V1UserTagMediasChunk.java) — `GET /v1/user/tag/medias/chunk`.
- [Get user stories by ID](../examples/endpoints/V1UserStories.java) — `GET /v1/user/stories`.
- [Get user stories by username (by ID is faster)](../examples/endpoints/V1UserStoriesByUsername.java) — `GET /v1/user/stories/by/username`.
- [Get user highlights by ID](../examples/endpoints/V1UserHighlights.java) — `GET /v1/user/highlights`.
- [Get user highlights by username (by ID is faster)](../examples/endpoints/V1UserHighlightsByUsername.java) — `GET /v1/user/highlights/by/username`.
- [Search in followers list by query (not working for legacy verified accounts)](../examples/endpoints/V1UserSearchFollowers.java) — `GET /v1/user/search/followers`.
- [Search in followings list by query (not working for legacy verified accounts)](../examples/endpoints/V1UserSearchFollowing.java) — `GET /v1/user/search/following`.
- [Get user following (chunked)](../examples/endpoints/V1UserFollowingChunk.java) — `GET /v1/user/following/chunk`.
- [Get user followers (chunked)](../examples/endpoints/V1UserFollowersChunk.java) — `GET /v1/user/followers/chunk`.
- [Get user info by ID](../examples/endpoints/V2UserById.java) — `GET /v2/user/by/id`.
- [Get user info by username](../examples/endpoints/V2UserByUsername.java) — `GET /v2/user/by/username`.
- [Get user stories by ID](../examples/endpoints/V2UserStories.java) — `GET /v2/user/stories`.
- [Get user stories by username](../examples/endpoints/V2UserStoriesByUsername.java) — `GET /v2/user/stories/by/username`.
- [Get user reels by ID](../examples/endpoints/V2UserClips.java) — `GET /v2/user/clips`.
- [Get user following list](../examples/endpoints/V2UserFollowing.java) — `GET /v2/user/following`.
- [Get user followers list](../examples/endpoints/V2UserFollowers.java) — `GET /v2/user/followers`.
- [Get media where user is tagged](../examples/endpoints/V2UserTagMedias.java) — `GET /v2/user/tag/medias`.
- [Get user highlights by ID](../examples/endpoints/V2UserHighlights.java) — `GET /v2/user/highlights`.
- [Get user highlights by username (by ID is faster)](../examples/endpoints/V2UserHighlightsByUsername.java) — `GET /v2/user/highlights/by/username`.
- [Get business suggestions for user](../examples/endpoints/V2UserExploreBusinessesById.java) — `GET /v2/user/explore/businesses/by/id`.
- [Get suggested profiles for user](../examples/endpoints/V2UserSuggestedProfiles.java) — `GET /v2/user/suggested/profiles`.
- [Get user followers (chunked)](../examples/endpoints/GqlUserFollowersChunk.java) — `GET /gql/user/followers/chunk`.
- [Get user following (chunked)](../examples/endpoints/GqlUserFollowingChunk.java) — `GET /gql/user/following/chunk`.
- [Get user reposts](../examples/endpoints/GqlUserReposts.java) — `GET /gql/user/reposts`.
- [Get user clips (reels)](../examples/endpoints/GqlUserClips.java) — `GET /gql/user/clips`.
- [Get user profile media (grid)](../examples/endpoints/GqlUserMedias.java) — `GET /gql/user/medias`.

</details>

<details>
<summary>Media · 20 examples</summary>

- [Get media info by ID](../examples/endpoints/V1MediaById.java) — `GET /v1/media/by/id`.
- [Get media info by shortcode](../examples/endpoints/V1MediaByCode.java) — `GET /v1/media/by/code`.
- [Get media info by URL](../examples/endpoints/V1MediaByUrl.java) — `GET /v1/media/by/url`.
- [Get media insights](../examples/endpoints/V1MediaInsight.java) — `GET /v1/media/insight`.
- [Get media comments (chunked)](../examples/endpoints/V1MediaCommentsChunk.java) — `GET /v1/media/comments/chunk`.
- [Get media likers](../examples/endpoints/V1MediaLikers.java) — `GET /v1/media/likers`.
- [Get author of the media](../examples/endpoints/V1MediaUser.java) — `GET /v1/media/user`.
- [Get media oEmbed data](../examples/endpoints/V1MediaOembed.java) — `GET /v1/media/oembed`.
- [Get media code from media ID (PK) (unlimited usage)](../examples/endpoints/V1MediaCodeFromPk.java) — `GET /v1/media/code/from/pk`.
- [Get media ID (PK) from shortcode (unlimited usage)](../examples/endpoints/V1MediaPkFromCode.java) — `GET /v1/media/pk/from/code`.
- [Get media ID (PK) from URL (unlimited usage)](../examples/endpoints/V1MediaPkFromUrl.java) — `GET /v1/media/pk/from/url`.
- [Get media info by ID](../examples/endpoints/V2MediaInfoById.java) — `GET /v2/media/info/by/id`.
- [Get media info by shortcode](../examples/endpoints/V2MediaInfoByCode.java) — `GET /v2/media/info/by/code`.
- [Get media info by URL](../examples/endpoints/V2MediaInfoByUrl.java) — `GET /v2/media/info/by/url`.
- [Get media comments](../examples/endpoints/V2MediaComments.java) — `GET /v2/media/comments`.
- [Get media likers](../examples/endpoints/V2MediaLikers.java) — `GET /v2/media/likers`.
- [Check comment for offensiveness](../examples/endpoints/V2MediaCommentOffensive.java) — `GET /v2/media/comment/offensive`.
- [Get comment replies](../examples/endpoints/V2MediaCommentsReplies.java) — `GET /v2/media/comments/replies`.
- [Get media likers by media ID](../examples/endpoints/GqlMediaLikers.java) — `GET /gql/media/likers`.
- [Get video usertags by media IDs](../examples/endpoints/GqlMediaUsertags.java) — `GET /gql/media/usertags`.

</details>

<details>
<summary>Story · 6 examples</summary>

- [Get story by ID](../examples/endpoints/V1StoryById.java) — `GET /v1/story/by/id`.
- [Get story by URL](../examples/endpoints/V1StoryByUrl.java) — `GET /v1/story/by/url`.
- [Download story by ID](../examples/endpoints/V1StoryDownload.java) — `GET /v1/story/download`.
- [Download story by direct media URL (unlimited usage)](../examples/endpoints/V1StoryDownloadByUrl.java) — `GET /v1/story/download/by/url`.
- [Download story file by story URL (IG story link)](../examples/endpoints/V1StoryDownloadByStoryUrl.java) — `GET /v1/story/download/by/story/url`.
- [Get story by ID](../examples/endpoints/V2StoryById.java) — `GET /v2/story/by/id`.

</details>

<details>
<summary>Highlight · 3 examples</summary>

- [Get highlight by ID](../examples/endpoints/V1HighlightById.java) — `GET /v1/highlight/by/id`.
- [Get highlight by URL](../examples/endpoints/V1HighlightByUrl.java) — `GET /v1/highlight/by/url`.
- [Get highlight by ID](../examples/endpoints/V2HighlightById.java) — `GET /v2/highlight/by/id`.

</details>

<details>
<summary>Location · 6 examples</summary>

- [Get location by ID](../examples/endpoints/V1LocationById.java) — `GET /v1/location/by/id`.
- [Get location top medias](../examples/endpoints/V1LocationMediasTop.java) — `GET /v1/location/medias/top`.
- [Get location recent medias](../examples/endpoints/V1LocationMediasRecent.java) — `GET /v1/location/medias/recent`.
- [Get location top medias (chunked)](../examples/endpoints/V1LocationMediasTopChunk.java) — `GET /v1/location/medias/top/chunk`.
- [Get location recent medias (chunked)](../examples/endpoints/V1LocationMediasRecentChunk.java) — `GET /v1/location/medias/recent/chunk`.
- [Search locations](../examples/endpoints/V1LocationSearch.java) — `GET /v1/location/search`.

</details>

<details>
<summary>Hashtag · 8 examples</summary>

- [Get hashtag by name](../examples/endpoints/V1HashtagByName.java) — `GET /v1/hashtag/by/name`.
- [Get hashtag top medias](../examples/endpoints/V1HashtagMediasTop.java) — `GET /v1/hashtag/medias/top`.
- [Get hashtag top medias (chunked)](../examples/endpoints/V1HashtagMediasTopChunk.java) — `GET /v1/hashtag/medias/top/chunk`.
- [Get hashtag recent medias (chunked)](../examples/endpoints/V1HashtagMediasTopRecentChunk.java) — `GET /v1/hashtag/medias/top/recent/chunk`.
- [Get hashtag clips (chunked)](../examples/endpoints/V1HashtagMediasClipsChunk.java) — `GET /v1/hashtag/medias/clips/chunk`.
- [Get hashtag by name](../examples/endpoints/V2HashtagByName.java) — `GET /v2/hashtag/by/name`.
- [Get hashtag top medias](../examples/endpoints/V2HashtagMediasTop.java) — `GET /v2/hashtag/medias/top`.
- [Get hashtag recent medias](../examples/endpoints/V2HashtagMediasRecent.java) — `GET /v2/hashtag/medias/recent`.

</details>

<details>
<summary>Search · 5 examples</summary>

- [Search hashtags](../examples/endpoints/V1SearchHashtags.java) — `GET /v1/search/hashtags`.
- [Search users](../examples/endpoints/V1SearchUsers.java) — `GET /v1/search/users`.
- [Search music](../examples/endpoints/V1SearchMusic.java) — `GET /v1/search/music`.
- [Search hashtags](../examples/endpoints/V2SearchHashtags.java) — `GET /v2/search/hashtags`.
- [Search music](../examples/endpoints/V2SearchMusic.java) — `GET /v2/search/music`.

</details>

<details>
<summary>Fbsearch · 8 examples</summary>

- [Search places](../examples/endpoints/V1FbsearchPlaces.java) — `GET /v1/fbsearch/places`.
- [Top search](../examples/endpoints/V1FbsearchTopsearch.java) — `GET /v1/fbsearch/topsearch`.
- [Search accounts (users)](../examples/endpoints/V2FbsearchAccounts.java) — `GET /v2/fbsearch/accounts`.
- [Search places (locations)](../examples/endpoints/V2FbsearchPlaces.java) — `GET /v2/fbsearch/places`.
- [Top search](../examples/endpoints/V2FbsearchTopsearch.java) — `GET /v2/fbsearch/topsearch`.
- [Search reels (clips)](../examples/endpoints/V2FbsearchReels.java) — `GET /v2/fbsearch/reels`.
- [Search users](../examples/endpoints/V3FbsearchAccounts.java) — `GET /v3/fbsearch/accounts`.
- [Search places (locations)](../examples/endpoints/V3FbsearchPlaces.java) — `GET /v3/fbsearch/places`.

</details>

<details>
<summary>Userstream · 2 examples</summary>

- [Get user info stream by ID](../examples/endpoints/V2UserstreamById.java) — `GET /v2/userstream/by/id`.
- [Get user info stream by username](../examples/endpoints/V2UserstreamByUsername.java) — `GET /v2/userstream/by/username`.

</details>

<details>
<summary>Track · 2 examples</summary>

- [Get music feed by canonical ID](../examples/endpoints/V2TrackByCanonicalId.java) — `GET /v2/track/by/canonical/id`.
- [Get music feed by ID](../examples/endpoints/V2TrackById.java) — `GET /v2/track/by/id`.

</details>

<details>
<summary>Comments · 2 examples</summary>

- [Get comments list by media ID (chunked)](../examples/endpoints/GqlCommentsChunk.java) — `GET /gql/comments/chunk`.
- [Get threaded replies list by comment ID (chunked)](../examples/endpoints/GqlCommentsThreadedChunk.java) — `GET /gql/comments/threaded/chunk`.

</details>

<details>
<summary>Comment · 1 examples</summary>

- [Get comment likers list by comment ID (chunked)](../examples/endpoints/GqlCommentLikersChunk.java) — `GET /gql/comment/likers/chunk`.

</details>

<details>
<summary>Topsearch · 1 examples</summary>

- [Search top content by keyword](../examples/endpoints/GqlTopsearch.java) — `GET /gql/topsearch`.

</details>

## Configuration

Default API base URL: **`https://ig.jsonscraper.com`**. Configure the constructor arguments `baseUrl`, `timeout` (`Duration`), `retries`, and `cacheTimeout`. HTTPS is required except for explicit localhost test servers. Default timeout is 30 seconds.

Retries default to **0**; opt in to 0–5 retries for HTTP 429, 502, 503 and 504. Numeric `Retry-After` is respected up to 60 seconds; otherwise bounded exponential backoff applies. HTTP-date values use backoff. Retries may consume API quota, and total elapsed time can exceed one request timeout.

The configured license key is sent using the API's `license_key` query parameter. It overrides per-request attempts to supply a different key. Redirects are disabled, TLS verification stays enabled, and transport errors do not include request URLs. Keep credential-bearing URLs out of your application and reverse-proxy logs.

## Errors, pagination and caching

HTTP exceptions expose the status code and retry information. Transport failures have a credential-safe message. HTTP 200 alone is not application success: inspect `status` and any quota/product error fields. HTTP 403 can indicate an access restriction; 429 means you should wait or check the plan's limits.

Pagination is endpoint-specific. Pass a returned cursor unchanged to the next request, stop when `has_more` is false/0, and stop if a cursor repeats. Always set your own page/request budget. The SDK does not invent cursor fields or automatically spend your quota.

`cache_timeout=60` enables API-side caching for 60 seconds; `0` disables it. See the current product terms for quota treatment. The SDK does not cache responses locally.

Large IDs must remain strings in your application. Python preserves integer precision; JavaScript converts unsafe JSON integers to strings; PHP uses `JSON_BIGINT_AS_STRING`; Go provides `Decode()` with `json.Number`; Java returns response bytes for your chosen JSON library; C# exposes bytes and `JsonDocument`.

## FAQ

**Is this the official platform API?** This is the jsonscraper service SDK. jsonscraper is independent and is not affiliated with or endorsed by Instagram, Meta.

**Is the library free?** The SDK source is MIT-licensed. The hosted API requires a separate paid license. See [current plans and access](https://jsonscraper.com/services/ig-scraper-api?utm_source=github&utm_medium=sdk&utm_campaign=instagram-api-java&utm_content=faq).

**Does it work without a key?** A valid product license key is required for normal API requests. Never use a README example as a source of credentials.

**Can I use it in an existing application?** Yes. Install the package, configure the client, and call it from your server-side service. It does not require a web framework.

**Where do I ask for help?** For reproducible SDK bugs, open a [GitHub issue](https://github.com/jsonscraper/instagram-api-java/issues) with sanitized details. For plans, license questions and service support, use [jsonscraper contacts](https://jsonscraper.com/contacts?utm_source=github&utm_medium=sdk&utm_campaign=instagram-api-java&utm_content=support).

## Development and releases

```sh
python3 tests/contract.py
```

Tests run offline against a local/mock HTTP server and require no API key. A GitHub Actions template is included in `docs/github-actions.yml`; enabling it later requires `workflow` permission. No automatic workflow is enabled by this release.

See [CHANGELOG.md](../CHANGELOG.md) for release notes. Package registry publishing is tracked separately from the public GitHub source release.

## Privacy

The SDK includes no installation, API usage or conversion telemetry. It sends requests only to the configured API endpoint. README website links carry UTM campaign parameters so jsonscraper can attribute website visits and actions to this repository; website tracking respects Do Not Track and Global Privacy Control. Purchase clicks are measured as intent, not confirmed payment.
