# Semantic Kernel: Chat With Your Data


## Background
[Retrieval Augmented Generation aka RAG](https://en.wikipedia.org/wiki/Large_language_model) is an approach that perfectly blends two worlds of AI: The power of information search, like a typical search engine, with text generation, which is a key feature of LLMs. RAG consists of two flows: domain data embedding and text generation. Embedding is the process by which text is given numerical representation in a vector space. Once domain data is embedded, LLM generates more accurate answers by using text search.
<table width="256px">
  <tr>
    <td><img src="/posts/semantic-kernel/diagram_1.png"/></td>
  </tr>
  <tr>
    <td align="center">Retrieval Augmented Generation</td>
  </tr>
</table> 


## Building Blocks
To build a Gen AI applications we need building blocks: Flow, State and Side Effects. Flow governs the order of operations, State represents the current data, and Side Effects are changes that happen outside of a local scope. 
