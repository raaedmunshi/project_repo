# Efficacy of Sensor Readings
This project is an implementation machine learning models to predict the remaining useful life (RUL) of NASA jet engines based on sensor readings, using Generalized Additive Model (GAM), LSTM, Decision Trees, Random Forest, and XGBoost. The models were evaluated using metrics like  Mean Squared Error (MSE), Root Mean Squared Error (RMSE), and R-squared (R2) values., with LSTM providing the highest R2 value. Key factors affecting RUL included temperature, pressure, and vibration sensor readings. The project demonstrated the potential for predictive maintenance, enhancing engine longevity and operational efficiency in the aerospace industry.

## Data Description
The data comes from a computer simulation model of an aircraft engine [5]. The model generates run-to-failure data. Furthermore, sensor data and operational settings are recorded throughout engine runs. The data is time-series and the main goal is to predict the Remaining Useful Life (RUL). RUL is a concept used in prognostics to estimate the remaining operational life of a component or system. It refers to the amount of time that a component or system can continue to operate before it reaches the end of its useful life and requires maintenance, repair, or replacement. For this scenario, RUL represents the number of remaining cycles before an engine dies at every time step.

Below is a description of all the dataset:

<img width= 250 src=https://github.com/raaedmunshi/project_repo/assets/124057630/b3b8cb0e-55c7-4365-b419-8a36cbb68dd8>

<img width=250 src=https://github.com/raaedmunshi/project_repo/assets/124057630/5278c9a8-69f6-4989-868d-0a8c85f74680>

In terms of preprocessing, data was clean with no missing values and inconsistencies, however, we removed variables with zero variance (TRA, T2, P2, epr, farB,  Nf_dmd, PCNfR_dmd).
## Dimensionality reduction using PCA
To reduce the number of variables, PCA was used. Below is the plot:
![image](https://github.com/raaedmunshi/project_repo/assets/124057630/18409fc0-27aa-43d6-b9a6-a6a3768f9c31)

After conducting PCA on the data and plotting the first 2 PCs in a biplot. it can be seen that there are clear groupings and correlations. To begin with, (W31, W32, phi, P30) are highly correlated on PC1 and also highly correlated with the response RUL. In addition, (T30, htBleed, Ps30, NRf, Nf, BPR, T50, T24) are grouped together and are opposite to the previously-mentioned group which indicates that RUL decreases with any increase in this group. Additionally, there is a third grouping of (NRc and Nc) and they are almost perpendicular to RUL which indicates that there is very little correlation between them and RUL. Finally, P15 and the operational settings have little correlation on any PC which is likely due to low variability across engine runs.
Relating to the structure of the jet engine, it can be seen that sensor readings relating to HPC (P30, Ps30, phi, NRf, BPR) highly correlate with RUL. This goes in agreement with the FAA’s statement on the relationship between HPC failure and engine RUL.
## Feature Importance using Random Forest
To understand which features to use in the models, the Random Forest Variable Importance plot was used. Below is the plot:

![image](https://github.com/raaedmunshi/project_repo/assets/124057630/2967d11c-25cf-467e-a657-1d408e84257d)

As can be seen from the variable importance plot, most of the sensor inputs have a greater importance than the operating settings themselves. The sensors relating to Nc, Rc, Nf, P30, NRf, BPR, phi, and others are either directly related to the HPC. Some of these factors are related to the speed of the core or the fan, which directly correlate to the stress on the HPC; P30 relates to the pressure of the HPC; phi relates to the ratio of fuel flow to the static pressure of the HPC. This means that factors that affect the HPC and the wellness of the HPC are the greatest indicators and most important predictors of the remaining useful life of the jet engines. This is in agreement with the FAA’s statement about most jet engine failures being primarily caused by the health of the engine’s compressors.
## Results
Below are the results after running all the models:
![image](https://github.com/raaedmunshi/project_repo/assets/124057630/153f1d7c-6a63-4e0d-acda-ad7ec77f1e49)

Overall, the models used to predict RUL with varying accuracy. On one hand, LSTM outperformed all other models with an R^2 value of 0.91, meanwhile, XGBoost gave the lowest R^2 value of 0.565. For the rest of the models, GAM, SVM with polynomial kernels, and random forest achieved R^2 in the 0.6 range, while SVM with radial kernel achieved R^2 of 0.74. Furthermore, based on PCA and variable importance plots generated, the results confirm the statement by the Federal Aviation Administration (FAA) that the operating conditions related to the high-pressure compressors (HPC) are critical for determining the remaining useful life of a jet engine.
