
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

After running through all the ML models, the sample with the ranges had a higher accuracy, therefore, we use the sample with the ranges
## Methodology
1. Hyperparameter tuning on all data variables and determining the initial results
2. Feature Selection and determining the best results for the number of features
3. PCA and determining the best results for the number of components.

## Class Imbalance
Below you can see the class imbalance in the target variable "RESISTANCE_STATUS" with its three classes: Confirmed Resistance (class 0), Possible resistance (class 1) and Susceptible (class 2):

<img width="203" alt="image" src="https://github.com/raaedmunshi/project_repo/assets/124057630/b4076f67-6e6b-4f88-88d8-fba0c20500a7">

To combat this imbalance we performed 4 SMOTE techniques:

- Oversampling
- Undersampling
- Oversampling and Undersampling
- Stratified sampling coupled with Oversampling and Undersampling

We ran all 4 methods through a decision tree to decide on which method to use, below are the results:

<img alt="image" src="https://github.com/raaedmunshi/project_repo/assets/124057630/ae05dd41-1472-410a-a75d-65cce4e40bd6">

To understand which method performed the best, we will use the F1-score as it accounts for class imbalances. As a result, stratified sampling coupled with oversampling and undersampling resulted in the highest F1-score by a far margin compared to other methods. Therefore, we used this method throughout.

## Feature importance and Dimensionality Reduction
To use the more important features we perform Mutual Information Classifier and Random Forest Variable Importance. Below are the set of variables selected from each method:
- Random Forest Variable Importance:
['SITE_NAME', 'MOSQUITO_NUMBER', 'COUNTRY_NAME', 'ADMIN2', 'ADMIN1', 'SPECIES', 'INSECTICIDE_CONC', 'INSECTICIDE_TYPE', 'INSECTICIDE_CLASS', 'TEST_TYPE']

- Mutual Information Classifier Variable Importance:
['COUNTRY_NAME', 'INSECTICIDE_CLASS', 'ADMIN1', 'ADMIN2', 'SITE_NAME', 'INSECTICIDE_TYPE', 'INSECTICIDE_CONC', 'MOSQUITO_NUMBER', 'SPECIES', 'TEST_TYPE']

To experiment more, we used PCA for dimensionality reduction. As a result, it was reduced to 2 variables.
## Results
After experimenting with all these methods, below is a table summarizing the results:
<img alt="image" src="https://github.com/raaedmunshi/project_repo/assets/124057630/ab50ce2e-8249-4a6a-a506-7835762ad7b9">

Using Stratified sampling coupled with Oversampling and Undersampling of data, it was noted that the best Decision tree model with the maximum depth as 15, minimum samples leaf as 3, and minimum samples split as 6 as well as the best Decision tree model coupled with Random forest feature selection with number of features, k=7, resulted in the best testing accuracy=70%.



