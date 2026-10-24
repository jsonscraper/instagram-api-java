# Instagram java request examples

Every file below is a complete single-request CLI program with environment-based authentication, all documented query options, timeout configuration, error handling and full response output. Sample defaults come from Postman; replace account names, IDs and URLs for your use case. `--help` requires no API key and makes no network request.

Compile the SDK with Maven, then compile an example with `javac -cp target/classes -d examples/endpoints examples/endpoints/ExampleName.java`. Run with `java -cp target/classes:examples/endpoints ExampleName --help` (use `;` as the classpath separator on Windows).

Set `JSONSCRAPER_INSTAGRAM_LICENSE_KEY` and install the SDK as described in the main README. Each execution makes one live request and may consume quota. None of these programs loops through a feed automatically.

## Get user info by ID

[Open the complete example](endpoints/V1UserById.java) · `GET /v1/user/by/id`

```sh
java -cp target/classes:examples/endpoints V1UserById --help
```

## Get user info by username (by ID is faster)

[Open the complete example](endpoints/V1UserByUsername.java) · `GET /v1/user/by/username`

```sh
java -cp target/classes:examples/endpoints V1UserByUsername --help
```

## Get user info by URL (by ID is faster)

[Open the complete example](endpoints/V1UserByUrl.java) · `GET /v1/user/by/url`

```sh
java -cp target/classes:examples/endpoints V1UserByUrl --help
```

## Get info about user by ID

[Open the complete example](endpoints/V1UserAbout.java) · `GET /v1/user/about`

```sh
java -cp target/classes:examples/endpoints V1UserAbout --help
```

## Get posts (chunked)

[Open the complete example](endpoints/V1UserMediasChunk.java) · `GET /v1/user/medias/chunk`

```sh
java -cp target/classes:examples/endpoints V1UserMediasChunk --help
```

## Get pinned posts

[Open the complete example](endpoints/V1UserMediasPinned.java) · `GET /v1/user/medias/pinned`

```sh
java -cp target/classes:examples/endpoints V1UserMediasPinned --help
```

## Get reels (chunked)

[Open the complete example](endpoints/V1UserClipsChunk.java) · `GET /v1/user/clips/chunk`

```sh
java -cp target/classes:examples/endpoints V1UserClipsChunk --help
```

## Get tagged (mentions) posts

[Open the complete example](endpoints/V1UserTagMediasChunk.java) · `GET /v1/user/tag/medias/chunk`

```sh
java -cp target/classes:examples/endpoints V1UserTagMediasChunk --help
```

## Get user stories by ID

[Open the complete example](endpoints/V1UserStories.java) · `GET /v1/user/stories`

```sh
java -cp target/classes:examples/endpoints V1UserStories --help
```

## Get user stories by username (by ID is faster)

[Open the complete example](endpoints/V1UserStoriesByUsername.java) · `GET /v1/user/stories/by/username`

```sh
java -cp target/classes:examples/endpoints V1UserStoriesByUsername --help
```

## Get user highlights by ID

[Open the complete example](endpoints/V1UserHighlights.java) · `GET /v1/user/highlights`

```sh
java -cp target/classes:examples/endpoints V1UserHighlights --help
```

## Get user highlights by username (by ID is faster)

[Open the complete example](endpoints/V1UserHighlightsByUsername.java) · `GET /v1/user/highlights/by/username`

```sh
java -cp target/classes:examples/endpoints V1UserHighlightsByUsername --help
```

## Search in followers list by query (not working for legacy verified accounts)

[Open the complete example](endpoints/V1UserSearchFollowers.java) · `GET /v1/user/search/followers`

```sh
java -cp target/classes:examples/endpoints V1UserSearchFollowers --help
```

## Search in followings list by query (not working for legacy verified accounts)

[Open the complete example](endpoints/V1UserSearchFollowing.java) · `GET /v1/user/search/following`

```sh
java -cp target/classes:examples/endpoints V1UserSearchFollowing --help
```

## Get user following (chunked)

[Open the complete example](endpoints/V1UserFollowingChunk.java) · `GET /v1/user/following/chunk`

```sh
java -cp target/classes:examples/endpoints V1UserFollowingChunk --help
```

## Get user followers (chunked)

[Open the complete example](endpoints/V1UserFollowersChunk.java) · `GET /v1/user/followers/chunk`

```sh
java -cp target/classes:examples/endpoints V1UserFollowersChunk --help
```

## Get media info by ID

[Open the complete example](endpoints/V1MediaById.java) · `GET /v1/media/by/id`

```sh
java -cp target/classes:examples/endpoints V1MediaById --help
```

## Get media info by shortcode

[Open the complete example](endpoints/V1MediaByCode.java) · `GET /v1/media/by/code`

```sh
java -cp target/classes:examples/endpoints V1MediaByCode --help
```

## Get media info by URL

[Open the complete example](endpoints/V1MediaByUrl.java) · `GET /v1/media/by/url`

```sh
java -cp target/classes:examples/endpoints V1MediaByUrl --help
```

## Get media insights

[Open the complete example](endpoints/V1MediaInsight.java) · `GET /v1/media/insight`

```sh
java -cp target/classes:examples/endpoints V1MediaInsight --help
```

## Get media comments (chunked)

[Open the complete example](endpoints/V1MediaCommentsChunk.java) · `GET /v1/media/comments/chunk`

```sh
java -cp target/classes:examples/endpoints V1MediaCommentsChunk --help
```

## Get media likers

[Open the complete example](endpoints/V1MediaLikers.java) · `GET /v1/media/likers`

```sh
java -cp target/classes:examples/endpoints V1MediaLikers --help
```

## Get author of the media

[Open the complete example](endpoints/V1MediaUser.java) · `GET /v1/media/user`

```sh
java -cp target/classes:examples/endpoints V1MediaUser --help
```

## Get media oEmbed data

[Open the complete example](endpoints/V1MediaOembed.java) · `GET /v1/media/oembed`

```sh
java -cp target/classes:examples/endpoints V1MediaOembed --help
```

## Get media code from media ID (PK) (unlimited usage)

[Open the complete example](endpoints/V1MediaCodeFromPk.java) · `GET /v1/media/code/from/pk`

```sh
java -cp target/classes:examples/endpoints V1MediaCodeFromPk --help
```

## Get media ID (PK) from shortcode (unlimited usage)

[Open the complete example](endpoints/V1MediaPkFromCode.java) · `GET /v1/media/pk/from/code`

```sh
java -cp target/classes:examples/endpoints V1MediaPkFromCode --help
```

## Get media ID (PK) from URL (unlimited usage)

[Open the complete example](endpoints/V1MediaPkFromUrl.java) · `GET /v1/media/pk/from/url`

```sh
java -cp target/classes:examples/endpoints V1MediaPkFromUrl --help
```

## Get story by ID

[Open the complete example](endpoints/V1StoryById.java) · `GET /v1/story/by/id`

```sh
java -cp target/classes:examples/endpoints V1StoryById --help
```

## Get story by URL

[Open the complete example](endpoints/V1StoryByUrl.java) · `GET /v1/story/by/url`

```sh
java -cp target/classes:examples/endpoints V1StoryByUrl --help
```

## Download story by ID

[Open the complete example](endpoints/V1StoryDownload.java) · `GET /v1/story/download`

```sh
java -cp target/classes:examples/endpoints V1StoryDownload --help
```

## Download story by direct media URL (unlimited usage)

[Open the complete example](endpoints/V1StoryDownloadByUrl.java) · `GET /v1/story/download/by/url`

```sh
java -cp target/classes:examples/endpoints V1StoryDownloadByUrl --help
```

## Download story file by story URL (IG story link)

[Open the complete example](endpoints/V1StoryDownloadByStoryUrl.java) · `GET /v1/story/download/by/story/url`

```sh
java -cp target/classes:examples/endpoints V1StoryDownloadByStoryUrl --help
```

## Get highlight by ID

[Open the complete example](endpoints/V1HighlightById.java) · `GET /v1/highlight/by/id`

```sh
java -cp target/classes:examples/endpoints V1HighlightById --help
```

## Get highlight by URL

[Open the complete example](endpoints/V1HighlightByUrl.java) · `GET /v1/highlight/by/url`

```sh
java -cp target/classes:examples/endpoints V1HighlightByUrl --help
```

## Get location by ID

[Open the complete example](endpoints/V1LocationById.java) · `GET /v1/location/by/id`

```sh
java -cp target/classes:examples/endpoints V1LocationById --help
```

## Get location top medias

[Open the complete example](endpoints/V1LocationMediasTop.java) · `GET /v1/location/medias/top`

```sh
java -cp target/classes:examples/endpoints V1LocationMediasTop --help
```

## Get location recent medias

[Open the complete example](endpoints/V1LocationMediasRecent.java) · `GET /v1/location/medias/recent`

```sh
java -cp target/classes:examples/endpoints V1LocationMediasRecent --help
```

## Get location top medias (chunked)

[Open the complete example](endpoints/V1LocationMediasTopChunk.java) · `GET /v1/location/medias/top/chunk`

```sh
java -cp target/classes:examples/endpoints V1LocationMediasTopChunk --help
```

## Get location recent medias (chunked)

[Open the complete example](endpoints/V1LocationMediasRecentChunk.java) · `GET /v1/location/medias/recent/chunk`

```sh
java -cp target/classes:examples/endpoints V1LocationMediasRecentChunk --help
```

## Search locations

[Open the complete example](endpoints/V1LocationSearch.java) · `GET /v1/location/search`

```sh
java -cp target/classes:examples/endpoints V1LocationSearch --help
```

## Get hashtag by name

[Open the complete example](endpoints/V1HashtagByName.java) · `GET /v1/hashtag/by/name`

```sh
java -cp target/classes:examples/endpoints V1HashtagByName --help
```

## Get hashtag top medias

[Open the complete example](endpoints/V1HashtagMediasTop.java) · `GET /v1/hashtag/medias/top`

```sh
java -cp target/classes:examples/endpoints V1HashtagMediasTop --help
```

## Get hashtag top medias (chunked)

[Open the complete example](endpoints/V1HashtagMediasTopChunk.java) · `GET /v1/hashtag/medias/top/chunk`

```sh
java -cp target/classes:examples/endpoints V1HashtagMediasTopChunk --help
```

## Get hashtag recent medias (chunked)

[Open the complete example](endpoints/V1HashtagMediasTopRecentChunk.java) · `GET /v1/hashtag/medias/top/recent/chunk`

```sh
java -cp target/classes:examples/endpoints V1HashtagMediasTopRecentChunk --help
```

## Get hashtag clips (chunked)

[Open the complete example](endpoints/V1HashtagMediasClipsChunk.java) · `GET /v1/hashtag/medias/clips/chunk`

```sh
java -cp target/classes:examples/endpoints V1HashtagMediasClipsChunk --help
```

## Search hashtags

[Open the complete example](endpoints/V1SearchHashtags.java) · `GET /v1/search/hashtags`

```sh
java -cp target/classes:examples/endpoints V1SearchHashtags --help
```

## Search users

[Open the complete example](endpoints/V1SearchUsers.java) · `GET /v1/search/users`

```sh
java -cp target/classes:examples/endpoints V1SearchUsers --help
```

## Search music

[Open the complete example](endpoints/V1SearchMusic.java) · `GET /v1/search/music`

```sh
java -cp target/classes:examples/endpoints V1SearchMusic --help
```

## Search places

[Open the complete example](endpoints/V1FbsearchPlaces.java) · `GET /v1/fbsearch/places`

```sh
java -cp target/classes:examples/endpoints V1FbsearchPlaces --help
```

## Top search

[Open the complete example](endpoints/V1FbsearchTopsearch.java) · `GET /v1/fbsearch/topsearch`

```sh
java -cp target/classes:examples/endpoints V1FbsearchTopsearch --help
```

## Get user info by ID

[Open the complete example](endpoints/V2UserById.java) · `GET /v2/user/by/id`

```sh
java -cp target/classes:examples/endpoints V2UserById --help
```

## Get user info by username

[Open the complete example](endpoints/V2UserByUsername.java) · `GET /v2/user/by/username`

```sh
java -cp target/classes:examples/endpoints V2UserByUsername --help
```

## Get user info stream by ID

[Open the complete example](endpoints/V2UserstreamById.java) · `GET /v2/userstream/by/id`

```sh
java -cp target/classes:examples/endpoints V2UserstreamById --help
```

## Get user info stream by username

[Open the complete example](endpoints/V2UserstreamByUsername.java) · `GET /v2/userstream/by/username`

```sh
java -cp target/classes:examples/endpoints V2UserstreamByUsername --help
```

## Get user stories by ID

[Open the complete example](endpoints/V2UserStories.java) · `GET /v2/user/stories`

```sh
java -cp target/classes:examples/endpoints V2UserStories --help
```

## Get user stories by username

[Open the complete example](endpoints/V2UserStoriesByUsername.java) · `GET /v2/user/stories/by/username`

```sh
java -cp target/classes:examples/endpoints V2UserStoriesByUsername --help
```

## Get user reels by ID

[Open the complete example](endpoints/V2UserClips.java) · `GET /v2/user/clips`

```sh
java -cp target/classes:examples/endpoints V2UserClips --help
```

## Get user following list

[Open the complete example](endpoints/V2UserFollowing.java) · `GET /v2/user/following`

```sh
java -cp target/classes:examples/endpoints V2UserFollowing --help
```

## Get user followers list

[Open the complete example](endpoints/V2UserFollowers.java) · `GET /v2/user/followers`

```sh
java -cp target/classes:examples/endpoints V2UserFollowers --help
```

## Get media where user is tagged

[Open the complete example](endpoints/V2UserTagMedias.java) · `GET /v2/user/tag/medias`

```sh
java -cp target/classes:examples/endpoints V2UserTagMedias --help
```

## Get user highlights by ID

[Open the complete example](endpoints/V2UserHighlights.java) · `GET /v2/user/highlights`

```sh
java -cp target/classes:examples/endpoints V2UserHighlights --help
```

## Get user highlights by username (by ID is faster)

[Open the complete example](endpoints/V2UserHighlightsByUsername.java) · `GET /v2/user/highlights/by/username`

```sh
java -cp target/classes:examples/endpoints V2UserHighlightsByUsername --help
```

## Get business suggestions for user

[Open the complete example](endpoints/V2UserExploreBusinessesById.java) · `GET /v2/user/explore/businesses/by/id`

```sh
java -cp target/classes:examples/endpoints V2UserExploreBusinessesById --help
```

## Get suggested profiles for user

[Open the complete example](endpoints/V2UserSuggestedProfiles.java) · `GET /v2/user/suggested/profiles`

```sh
java -cp target/classes:examples/endpoints V2UserSuggestedProfiles --help
```

## Get media info by ID

[Open the complete example](endpoints/V2MediaInfoById.java) · `GET /v2/media/info/by/id`

```sh
java -cp target/classes:examples/endpoints V2MediaInfoById --help
```

## Get media info by shortcode

[Open the complete example](endpoints/V2MediaInfoByCode.java) · `GET /v2/media/info/by/code`

```sh
java -cp target/classes:examples/endpoints V2MediaInfoByCode --help
```

## Get media info by URL

[Open the complete example](endpoints/V2MediaInfoByUrl.java) · `GET /v2/media/info/by/url`

```sh
java -cp target/classes:examples/endpoints V2MediaInfoByUrl --help
```

## Get media comments

[Open the complete example](endpoints/V2MediaComments.java) · `GET /v2/media/comments`

```sh
java -cp target/classes:examples/endpoints V2MediaComments --help
```

## Get media likers

[Open the complete example](endpoints/V2MediaLikers.java) · `GET /v2/media/likers`

```sh
java -cp target/classes:examples/endpoints V2MediaLikers --help
```

## Check comment for offensiveness

[Open the complete example](endpoints/V2MediaCommentOffensive.java) · `GET /v2/media/comment/offensive`

```sh
java -cp target/classes:examples/endpoints V2MediaCommentOffensive --help
```

## Get comment replies

[Open the complete example](endpoints/V2MediaCommentsReplies.java) · `GET /v2/media/comments/replies`

```sh
java -cp target/classes:examples/endpoints V2MediaCommentsReplies --help
```

## Get story by ID

[Open the complete example](endpoints/V2StoryById.java) · `GET /v2/story/by/id`

```sh
java -cp target/classes:examples/endpoints V2StoryById --help
```

## Get music feed by canonical ID

[Open the complete example](endpoints/V2TrackByCanonicalId.java) · `GET /v2/track/by/canonical/id`

```sh
java -cp target/classes:examples/endpoints V2TrackByCanonicalId --help
```

## Get music feed by ID

[Open the complete example](endpoints/V2TrackById.java) · `GET /v2/track/by/id`

```sh
java -cp target/classes:examples/endpoints V2TrackById --help
```

## Get hashtag by name

[Open the complete example](endpoints/V2HashtagByName.java) · `GET /v2/hashtag/by/name`

```sh
java -cp target/classes:examples/endpoints V2HashtagByName --help
```

## Get hashtag top medias

[Open the complete example](endpoints/V2HashtagMediasTop.java) · `GET /v2/hashtag/medias/top`

```sh
java -cp target/classes:examples/endpoints V2HashtagMediasTop --help
```

## Get hashtag recent medias

[Open the complete example](endpoints/V2HashtagMediasRecent.java) · `GET /v2/hashtag/medias/recent`

```sh
java -cp target/classes:examples/endpoints V2HashtagMediasRecent --help
```

## Get highlight by ID

[Open the complete example](endpoints/V2HighlightById.java) · `GET /v2/highlight/by/id`

```sh
java -cp target/classes:examples/endpoints V2HighlightById --help
```

## Search hashtags

[Open the complete example](endpoints/V2SearchHashtags.java) · `GET /v2/search/hashtags`

```sh
java -cp target/classes:examples/endpoints V2SearchHashtags --help
```

## Search music

[Open the complete example](endpoints/V2SearchMusic.java) · `GET /v2/search/music`

```sh
java -cp target/classes:examples/endpoints V2SearchMusic --help
```

## Search accounts (users)

[Open the complete example](endpoints/V2FbsearchAccounts.java) · `GET /v2/fbsearch/accounts`

```sh
java -cp target/classes:examples/endpoints V2FbsearchAccounts --help
```

## Search places (locations)

[Open the complete example](endpoints/V2FbsearchPlaces.java) · `GET /v2/fbsearch/places`

```sh
java -cp target/classes:examples/endpoints V2FbsearchPlaces --help
```

## Top search

[Open the complete example](endpoints/V2FbsearchTopsearch.java) · `GET /v2/fbsearch/topsearch`

```sh
java -cp target/classes:examples/endpoints V2FbsearchTopsearch --help
```

## Search reels (clips)

[Open the complete example](endpoints/V2FbsearchReels.java) · `GET /v2/fbsearch/reels`

```sh
java -cp target/classes:examples/endpoints V2FbsearchReels --help
```

## Get comments list by media ID (chunked)

[Open the complete example](endpoints/GqlCommentsChunk.java) · `GET /gql/comments/chunk`

```sh
java -cp target/classes:examples/endpoints GqlCommentsChunk --help
```

## Get threaded replies list by comment ID (chunked)

[Open the complete example](endpoints/GqlCommentsThreadedChunk.java) · `GET /gql/comments/threaded/chunk`

```sh
java -cp target/classes:examples/endpoints GqlCommentsThreadedChunk --help
```

## Get comment likers list by comment ID (chunked)

[Open the complete example](endpoints/GqlCommentLikersChunk.java) · `GET /gql/comment/likers/chunk`

```sh
java -cp target/classes:examples/endpoints GqlCommentLikersChunk --help
```

## Search top content by keyword

[Open the complete example](endpoints/GqlTopsearch.java) · `GET /gql/topsearch`

```sh
java -cp target/classes:examples/endpoints GqlTopsearch --help
```

## Get media likers by media ID

[Open the complete example](endpoints/GqlMediaLikers.java) · `GET /gql/media/likers`

```sh
java -cp target/classes:examples/endpoints GqlMediaLikers --help
```

## Get video usertags by media IDs

[Open the complete example](endpoints/GqlMediaUsertags.java) · `GET /gql/media/usertags`

```sh
java -cp target/classes:examples/endpoints GqlMediaUsertags --help
```

## Get user followers (chunked)

[Open the complete example](endpoints/GqlUserFollowersChunk.java) · `GET /gql/user/followers/chunk`

```sh
java -cp target/classes:examples/endpoints GqlUserFollowersChunk --help
```

## Get user following (chunked)

[Open the complete example](endpoints/GqlUserFollowingChunk.java) · `GET /gql/user/following/chunk`

```sh
java -cp target/classes:examples/endpoints GqlUserFollowingChunk --help
```

## Get user reposts

[Open the complete example](endpoints/GqlUserReposts.java) · `GET /gql/user/reposts`

```sh
java -cp target/classes:examples/endpoints GqlUserReposts --help
```

## Get user clips (reels)

[Open the complete example](endpoints/GqlUserClips.java) · `GET /gql/user/clips`

```sh
java -cp target/classes:examples/endpoints GqlUserClips --help
```

## Get user profile media (grid)

[Open the complete example](endpoints/GqlUserMedias.java) · `GET /gql/user/medias`

```sh
java -cp target/classes:examples/endpoints GqlUserMedias --help
```

## Search users

[Open the complete example](endpoints/V3FbsearchAccounts.java) · `GET /v3/fbsearch/accounts`

```sh
java -cp target/classes:examples/endpoints V3FbsearchAccounts --help
```

## Search places (locations)

[Open the complete example](endpoints/V3FbsearchPlaces.java) · `GET /v3/fbsearch/places`

```sh
java -cp target/classes:examples/endpoints V3FbsearchPlaces --help
```

