
import nltk;
from nltk.chat.util import Chat,reflections;

pairs=[
    (r"hi|hello|hey",
     ["hi,how can I help you?","Hi , how can I assist you!"]),
     (r"help|need",
     ["how can I help you?","how can I assist you!"]),
     (r"services|what services you provide",
     ["we provide healthcare services"]),
     (r"hours|open|available",
     ["we are available 24/7"]),
     (r"emergency|urgent",
     ["Contact on helpline 900","visit nearby emergency center"]),
     (r"cost|billing|insurance",
     ["visit our billing department","contact our billing department at 66666"]),
     (r"appointment|book|register",
     ["contact our reception","do visit hospital for appointment"]),
    (r"(.*)",
     ["Thank you for enquiry ","see you again"])
]

def create_chatbot():
    chatbot= Chat(pairs,reflections)
    print("Chatbot created successfully! ")
    return chatbot

def run_chatbot():
    chatbot = create_chatbot()
    while True:
        user_input= input(" > ")
        if user_input.lower()=='exit':
            break
        respond = chatbot.response(user_input)
        print(respond)


if __name__ == '__main__':
    nltk.download('punkt')
    run_chatbot()


