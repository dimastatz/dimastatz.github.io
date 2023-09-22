# Semantic Kernel: Chat With Your Data


## Background
LLMs are amazing at generating text and have a wide range of applications, but they're not a substitute for domain-specific knowledge and expertise. They work best when providing general information or context rather than specific, specialized knowledge. But imagine if we could connect LLM to specific data sources, such as organizational databases, PDF documents, books. This connection would allow LLM to tap into that proprietary information and provide more accurate responses within that particular domain.
[Retrieval Augmented Generation aka RAG](https://en.wikipedia.org/wiki/Large_language_model) is an approach that perfectly blends two worlds of AI: The power of information search, like a typical search engine, with text generation, which is a key feature of LLMs.

<table width="256px">
  <tr>
    <td><img src="/posts/semantic-kernel/diagram_1.png"/></td>
  </tr>
  <tr>
    <td align="center">Retrieval Augmented Generation</td>
  </tr>
</table> 

RAG consists of two flows: domain data embedding and text generation. Embedding is the process by which text is given numerical representation in a vector space. Once domain data is embedded, LLM generates more accurate answers by using text search.
 

## The Straightforward Implementation
[TBD]()


