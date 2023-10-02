# Semantic Kernel: Chat With Your Data


## Background
ChatGPT excels in general knowledge but may struggle in specific domains. [Retrieval Augmented Generation aka RAG](https://en.wikipedia.org/wiki/Large_language_model) is an approach that perfectly addresses the specific knowldge challenge. RAG blends two worlds of AI: The power of information search, like a typical search engine, with text generation, which is a key feature of LLMs. RAG consists of two flows: domain data embedding and text generation. Embedding is the process by which text is given numerical representation in a vector space. Once domain data is embedded, LLM generates more accurate answers by using text search.
<table width="256px">
  <tr>
    <td><img src="/posts/semantic-kernel/diagram_1.png"/></td>
  </tr>
  <tr>
    <td align="center">Retrieval Augmented Generation</td>
  </tr>
</table> 


## Navigating Challenges in Gen-AI Applications 
Using LLMs in software is simple and exciting. With just one LLM call, tasks that used to require hundreds of lines of code can be done. However, LLMs come with challenges. They behave unpredictably and may give different results for the same input. They're also pure functions, so integrating state into applications requires thought. Creating workflows, involving chaining functions and actions that alter state, is another challenge to tackle. All these challenges will be common in complex Gen-AI applications and a robust framework can greatly assist in overcoming them.

## Semantic Kernel
[Semantic Kernel](https://learn.microsoft.com/en-us/semantic-kernel/overview/), initially created by Microsoft, is an open-source Framework utilized in products like Microsoft 365 Copilot and Bing. It simplifies the integration of LLMs into applications by providing three fundamental building blocks: Flow for chaining actions into (e.g., stringing together LLM prompts in a conversation), State for managing Gen-AI app state, ussually a vector DB like [Pinecone](https://www.pinecone.io/) or [OpenSearch](https://aws.amazon.com/what-is/opensearch/), and Side Effects, out-of-the-box or a custom connectors to provide data or perform autonomous actions.


