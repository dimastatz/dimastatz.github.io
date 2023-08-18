# Building Virtual Assistants using LangChain.

## Background
[ChatGPT](https://en.wikipedia.org/wiki/ChatGPT) has impressive general knowledge, it can provide decent answers to various questions. However, when it comes to specific domains, its performance may fall short. But imagine if we could connect LLM to specific data sources, such as organizational databases, PDF documents, books, or other repositories of domain-specific knowledge. This connection would allow LLM to tap into that proprietary information and provide more accurate responses within that particular domain.

[LangChain](https://en.wikipedia.org/wiki/LangChain) is a framework that revolves around LLMs (Language Models) and makes it easy to reference external data sources without copy-pasting them into the LLM's prompt. But it doesn't stop there. LangChain also enables you to take action based on the obtained information, like sending emails, updating databases, or running scripts. Essentially, LangChain streamlines the integration between LLMs and external systems, allowing for dynamic and automated workflows beyond simple data referencing.

We can use LangChain Framework to build chatbots, Generative Question-Answering (GQA), summarization, and much more. LangChain has built-in support for integrations with systems including Amazon, Google, and Microsoft Azure cloud storage; API wrappers for news, movie information, and weather; Bash for summarization, syntax and semantics checking, and execution of shell scripts; multiple web scraping subsystems and templates; few-shot learning prompt generation support; finding and summarizing "todo" tasks in code; Google Drive documents, spreadsheets, and presentations summarization, extraction, and creation; Google Search and Microsoft Bing web search; OpenAI, Anthropic, and Hugging Face language models; iFixit repair guides and wikis search and summarization; MapReduce for question answering, and more.

## Virtual Assistants 
To clarify how LangChain simplifies the development process, let's examine the key components of the framework and apply them to the development of a virtual assistant for students called Smarti. Smarti provides students with a step-by-step explanation of how to solve problems from the student workbook. Essentially, Smarti has two flows: ingest flow and chat flow. Ingest flow is fairly simple, a student scans and uploads workbooks. Smarti performs the OCR job that translates images to text, parses questions, and sends each question to ChatGPT. ChatGPT solves the problem and sends the solution back to Smarti. Smarti combines questions and solutions to the text file and builds a local [Semantic Index](https://en.wikipedia.org/wiki/Latent_semantic_analysis). Doing so, each new problem is solved only once by the ChatGPT. The chat flow begins when the student's input is read and sent to Smarti for problem-solving. On the first attempt, Smarti tries to use PrivateGPT which uses a local Semantic Index. If the problem is found in the local semantic index, the step-by-step solution is served immediately. If the problem is not solved, Smarti uses ChatGPT to solve the problem and updates the local Semantic Index, and then serves the student's request.
<table width="256px">
  <tr>
    <td><img src="https://github.com/dimastatz/dimastatz.github.io/blob/main/posts/langchain/sequence-1.png"/></td>
  </tr>
  <tr>
    <td align="center">Smarti's Chat Flow</td>
  </tr>
</table> 


## Design Principles
There is a lot to unpack when learning LangChain, but at a high level there are 5 main components: 
- Models: LangChain provides building blocks to interface with any language model. For example, wrappers make calls to different language models through common interfaces. Another example is the output parsers that help to extract information from the model output.
- Prompts: a prompt refers to the input to the model. This input is often constructed from multiple components. LangChain provides several classes and functions to make constructing and working with prompts easy.
- Chains: complex applications require chaining LLMs - either with each other or with other components. LangChain provides the Chain interface for such "chained" applications. We define a Chain very generically as a sequence of calls to components, which can include other chains. 
- Data Stores: many LLM applications require user-specific data that is not part of the model's training set. LangChain provides building blocks to load, transform, store, and query the data.
- Agents: the Agent interface offers flexibility for applications needing a chain of calls to various tools based on user input. Agents can choose from a suite of tools, use multiple tools together, and decide on actions at each timestep (Action agents) or plan a sequence of actions upfront and execute them (Plan-and-execute agents).
<table width="256px">
  <tr>
    <td><img src="https://github.com/dimastatz/dimastatz.github.io/blob/main/posts/langchain/langchain.png"/></td>
  </tr>
  <tr>
    <td align="center">Smarti on LangChain</td>
  </tr>
</table>

## Implementation
Let's use code examples to make the idea of the LangChain more tangible and easier to understand. First create and activate a virtual environment by executing the following command.
```bash
python -m venv venv
source venv/bin/activate
```
Install langchain, openai and python-environ libraries using pip.
```
pip install langchain openai python-environ
```
Create OpenAI LLM and run a simple query
```python
import os
from langchain.llms import OpenAI
from langchain import PromptTemplate, LLMChain


API_KEY = os.environ['OA_KEY']

# simple call 
llm = OpenAI(model_name="text-davinci-003", openai_api_key=API_KEY)
question = "provide step by step solution to 2*3 + 4*5"
print(question, llm(question))

# basic prompt 
template = "What are the top {n} resources to learn math?"
prompt = PromptTemplate(template=template,input_variables=['n'])
chain = LLMChain(llm=llm,prompt=prompt)
input = {'n':3}
print(chain.run(input))
```




## Summary
Personal assistants are a perfect use case for the LangChain Framework. [Prompt Templates](https://docs.langchain.com/docs/components/prompts/prompt-template) guide how the personal assistant acts, [Memory](https://docs.langchain.com/docs/components/memory/chat_message_history) helps to hold a conversation (short term memory), [Chains](https://docs.langchain.com/docs/components/chains/) or more specifically [Index-related chains](https://docs.langchain.com/docs/components/chains/index_related_chains) helps to combine the domain specific data (stored in the indexes) with LLMs, and finally, [Agents](https://docs.langchain.com/docs/components/agents/) simplify interactions with the external resources, drive the decision-making and perform tasks.


  










