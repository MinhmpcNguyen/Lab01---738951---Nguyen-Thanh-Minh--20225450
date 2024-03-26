import streamlit as st
import torch
from langchain.prompts import PromptTemplate
from langchain_community.llms import CTransformers
from transformers import pipeline
from langchain.callbacks.streaming_stdout import StreamingStdOutCallbackHandler


    # Your code here
def getLLamaresponse(input_text, Number_words, style):
        llm = CTransformers(model='model/llama-2-7b-chat.ggmlv3.q8_0.bin', 
                        callbacks=[StreamingStdOutCallbackHandler()]
                        )  
        template = f'Write this for {style} with topic {input_text} within {Number_words} words'
        prompt = PromptTemplate(input_variables=["style", "text", "n_words"], template=template)
        llm_chain = LLMChain(prompt=prompt, llm=llm)
        response = llm_chain.invoke(prompt.format(style=style, input_text=input_text, n_words=Number_words))  # n_words not Number_words
        print(response)
        return response
   
    
    # Use the selected device
    
st.set_page_config(page_title="BlockchainQ&A", page_icon="Hi", layout='centered', initial_sidebar_state='collapsed')

st.header("BlockchainQ&A Hi")

input_text = st.text_input("Enter the topic")

col1, col2 = st.columns([5, 5])

with col1:
         Number_words = st.text_input("Number of Words")
with col2:
         style = st.selectbox('Writing this for', ('Researchers', 'Student', 'General People'), index=0)
   
submit = st.button("Generate")
if submit:
         st.write(getLLamaresponse(input_text, Number_words, style))




