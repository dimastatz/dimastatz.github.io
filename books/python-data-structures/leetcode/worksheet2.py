import pandas as pd


df = pd.read_parquet('/Users/dstatz/Documents/tmp/part-00003-70989667-c939-4c55-b32b-c415e4c1def9.c000.snappy.parquet')

df.info()
print(df)


