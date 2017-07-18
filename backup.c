#ifdef DEBUG
#define DEBUG_PRINT(format,...) printf("FILE: "__FILE__", LINE: %d: "format"/n", __LINE__, ##__VA_ARGS__)
#else
#define DEBUG_PRINT(format,...)
#endif


