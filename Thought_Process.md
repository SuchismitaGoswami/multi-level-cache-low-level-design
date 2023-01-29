## APIS
1. /put - Add an item to the cache
2. /get - Get an item from the cache
3. /stat - Provide statistics

## Strategies
1. Cache Eviction Strategy

## Interfaces
1. Cache Provider used in each Level 
2. Cache Storage Strategy
3. ILevelCache

## Models
1. Cache (implements CacheProvider)
2. ReadResponse (1. Value, 2. ReadTime)
3. WriteResponse (1. Value, 2. WriteTime)
4. Level
5. LevelCache (1. Cache 2. Level)
   1. put/get/stat APIS

## Services
1. MultiLevelCache
