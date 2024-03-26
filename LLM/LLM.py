import streamlit as st
import torch
from langchain.prompts import PromptTemplate
from langchain_community.llms import CTransformers
from transformers import pipeline
from langchain.callbacks.streaming_stdout import StreamingStdOutCallbackHandler
from langchain.chains import LLMChain
# Your code here

# Function to get response using LLAMA model
def getLLamaresponse(input_text, Number_words, style):
      # Check for GPU availability
    llm = CTransformers(
        model='model/llama-2-7b-chat.ggmlv3.q8_0.bin',
        model_type='llama',
        config={'max_new_tokens':2000,'temperature' : 0.01},
        
    )
    template = f'Write this for {style} with topic {input_text} within {Number_words} words'
    prompt = PromptTemplate(input_variables=["style", "text", "n_words"], template=template)
    
    response = llm(prompt.format(style=style, input_text=input_text, n_words=Number_words))  # n_words not Number_words
    print(response)
    return response

# Streamlit setup
st.set_page_config(page_title="BlockchainQ&A", page_icon="Hi", layout='centered', initial_sidebar_state='collapsed')
st.header("BlockchainQ&A Hi")

# Input fields
input_text = st.text_input("Enter the topic")

col1, col2 = st.columns([5, 5])

with col1:
    Number_words = st.text_input("Number of Words")
with col2:
    style = st.selectbox('Writing this for', ('Researchers', 'Student', 'General People'), index=0)
   
submit = st.button("Generate")
if submit:
    st.write(getLLamaresponse(input_text, Number_words, style))

