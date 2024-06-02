# Weed Detection using EfficientVit
This project is an implementation and evaluation of the deep learning model EfficientViT for weed detection solutions, focusing on its ability to handle small mask areas in semantic segmentation tasks. The model was tested on sugarbeet and sunflower datasets, demonstrating its effectiveness in accurately identifying and segmenting weeds within these crops. By achieving high precision in detecting small and intricate weed patterns, the project highlights the potential of EfficientViT in improving agricultural efficiency and crop management. This solution could lead to more targeted weed control, reducing the need for herbicides and promoting sustainable farming practices.

## Dataset Description
Two datasets were used in this project SugarBeet Dataset and Sunflower Dataset.
- SugarBeet Dataset:
The original dataset was gathered using an Unmanned Ground Vehicle (UGV) robot on a sugar beet farm near Bonn, Germany, over three months. A JAI camera equipped on the UGV captured RGB images of the sugar beet field. The dataset also included segmented mask annotations generated using a U-Net architecture. However, it was discovered that the masks produced by this method were inaccurately labeled and contained numerous errors. Consequently, 1600 images from this dataset underwent manual labeling, dividing them into 1000 training images, 300 validation images, and 300 testing images.
<img width = 325 src=https://github.com/raaedmunshi/project_repo/assets/124057630/3400f3fc-5de6-4a2e-915a-7991f93d007d>

- Sunflower Dataset:
The initial sunflower dataset comprises 500 images acquired by a UGV robot on a farm in Jesi, Italy, spanning one month. Two sample images from this dataset are illustrated in Figure 2. Similar to the issues encountered in the sugar beet dataset, the provided mask annotations were inaccurately labeled and exhibited overlapping segments. Consequently, the dataset underwent a manual labeling process and is now publicly accessible through the previously provided link. The manually labeled data consists of 300 training images, 50 validation images, and 150 testing images.
<img width = 325 src=https://github.com/raaedmunshi/project_repo/assets/124057630/10825744-e6e8-43db-adf4-741b6ba95523>

## EfficientVit
EfficientViT is from a group of high-speed vision transformers which addresses the computational inefficiency of existing models. It employs a new building block layout, optimizing memory efficiency by using a single memory-bound operation between efficient layers.  We use EfficientViT-L series for the cloud platforms to run our datasets. The study also identifies computational redundancy in attention maps across heads and proposes a cascaded group attention module to save computation costs and enhance diversity. EfficientViT achieves a notable balance between speed and accuracy, outperforming existing efficient models.

<img width = 325 src=https://github.com/raaedmunshi/project_repo/assets/124057630/fbe94d04-42bf-49cf-922f-b265caa57cfe>

## Results
Evaluating our datasets on the Efficient ViT - L series on pretrained weights of the segment anything model (SAM) and evaluated with the COCO 2017, we achieved the following:

Small: Metrics calculated specifically for segmentation regions with areas less than 
32^2 pixels.

Medium: Metrics calculated specifically for segmentation regions with areas between
32 ^2 and 96^2 pixels.

Large: Metrics calculated specifically for segmentation regions with areas greater than 
96 ^2 pixels.

Below is an example of how the weeds and crops are segmented:

<img width = 325 src=https://github.com/raaedmunshi/project_repo/assets/124057630/8d581861-0a23-4a61-b491-68679a109f46>

Below are the results of the training and testing on both datasets:
### Training Results
<img width = 325 src=https://github.com/raaedmunshi/project_repo/assets/124057630/57fb7e40-17c5-487d-aece-aa14aea2f0a3>

<img width = 325 src=https://github.com/raaedmunshi/project_repo/assets/124057630/3528faf6-a1e2-4d15-87fd-af18a0e35eff>

### Testing Results
<img width = 325 src=https://github.com/raaedmunshi/project_repo/assets/124057630/8be63d9d-8d14-45fb-8532-3fa48ba519dd>


<img width = 325 src=https://github.com/raaedmunshi/project_repo/assets/124057630/934d454b-c7e0-4c03-9cb6-746b34994482>

From all the L series results, the model worked best on the small mask which was for segmentation regions with areas less than 32^2 pixels and relatively had worse results with segmentation regions with areas greater than 96 ^2 pixels.



