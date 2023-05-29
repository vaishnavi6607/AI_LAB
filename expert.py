knowledge_base={
    'disease_1':{
        'symptoms':["head","body"],
        'treatment':"tablet",
        'risk factor':["sun"]
    },
    'disease_2':{
        'symptoms':["leg","hand"],
        'treatment':"tablet1",
        'risk factor':["moon"]
    },
     'disease_3':{
        'symptoms':["joint","face"],
        'treatment':"tablet2",
        'risk factor':["sun&moon"]
    }

}

def get_user_input():
    symptoms=[]
    while True:
        symptom = input("ENter symptom when finish 'done'")
        if symptom.lower()=='done':
            break
        symptoms.append(symptom)
    return symptoms

def diagnoses(symptoms):
    possible_symptoms=[]
    for disease,info in knowledge_base.items():
        if any (symptom in symptoms for symptom in info['symptoms']):
            possible_symptoms.append(disease)
    return possible_symptoms

def display_diagnosis(diagnoses):
    if len(diagnoses)>0:
        print("possible diagnoses")
        for disease in diagnoses:
            print('disease',disease)
            print("symptoms",knowledge_base[disease]['symptoms'])
            print("treatment",knowledge_base[disease]['treatment'])
            print("risk_factor",knowledge_base[disease]['risk factor'])
            print()
    else:
        print("no detected")

def main():
    symptoms = get_user_input()
    possible_diagnosis=diagnoses(symptoms)
    display_diagnosis(possible_diagnosis)

if __name__ =='__main__':
    main()


