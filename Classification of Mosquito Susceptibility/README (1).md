
# Classification of Mosquito Susceptibility

This research aims to develop a model capable of classifying the resistance status of malaria-causing mosquitoes to various insecticides using machine learning techniques. Primarily, we examine various factors including the type, class, and concentration of insecticide used, as well as the environmental conditions such as the country and year of the analysis, and characteristics of the mosquitoes like species and number present during the bioassay.
We use ML models like Decision Trees, KNN, SVM Linear and Non-Linear, and Naive Bayes

## Data Preprocessing
The data consists of 21,074 samples and 25 features. However, not all 25 features are important. Out of these 25 features, there exist only 10 crucial features for the problem we aim to solve. The target variable is “RESISTANCE_STATUS” which is the status of resistance to insecticide.
The 10 features we are focusing on are:

- COUNTRY_NAME: Name of the country where the bioassay was conducted
- INSECTICIDE_CLASS: Insecticide class
- INSECTICIDE_TYPE: Insecticide
- INSECTICIDE_CONC: Insecticide concentration
- YEAR_START: Year when the mosquito collection started
- VECTOR_SPECIES: Species of the mosquitoes exposed to insecticide
- MOSQUITO_NUMBER: Total number of mosquitoes exposed to insecticide during the bioassay
- ADMIN1 : Administrative level 1 where the mosquitos were collected
- ADMIN2 : Administrative level 2 where the mosquitos were collected
- SPECIES: Species of the mosquitoes exposed to insecticide

After that, we performed data preprocessing methods:

- Removed null values consisted of 0, “”, and “Not available”
- Encoding qualitative data
- Normalized qualitative data between 0 and 1
- 2 samples of the data, one where we keep the ranges of the “MOSQUITO_NUMBER” column by taking the median and the other where we remove the rows containing the ranges.
- In the 'INSECTICIDE_CONC' column, it had two metrics: % and µg, the values that were reported in 'µg' were dropped as significatly lower than %

# Class Imbalance

![class_imbalance]("class_imbalance.png")






