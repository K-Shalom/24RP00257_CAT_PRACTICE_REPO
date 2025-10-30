public class SoilAnalysis_24RP00257 {
    private String farmerId;
    private String districtName;
    private double nitrogenLevel;
    private double phosphorusLevel;
    private double potassiumLevel;
    private String cropType;

    public SoilAnalysis_24RP00257(String farmerId, String districtName, double nitrogenLevel,
                                  double phosphorusLevel, double potassiumLevel, String cropType) {
        this.farmerId = farmerId;
        this.districtName = districtName;
        this.nitrogenLevel = nitrogenLevel;
        this.phosphorusLevel = phosphorusLevel;
        this.potassiumLevel = potassiumLevel;
        this.cropType = cropType;
    }

    public String getFarmerId() { return farmerId; }
    public String getDistrictName() { return districtName; }
    public double getNitrogenLevel() { return nitrogenLevel; }
    public double getPhosphorusLevel() { return phosphorusLevel; }
    public double getPotassiumLevel() { return potassiumLevel; }
    public String getCropType() { return cropType; }

    public boolean isBalanced() {
        return isNutrientBalanced(nitrogenLevel) && 
               isNutrientBalanced(phosphorusLevel) && 
               isNutrientBalanced(potassiumLevel);
    }

    private boolean isNutrientBalanced(double level) {
        return level >= 20 && level <= 100;
    }

    public String calculateFertilizerNeeded() {
        if (nitrogenLevel <= 0 || phosphorusLevel <= 0 || potassiumLevel <= 0) {
            throw new IllegalArgumentException("Invalid nutrient reading");
        }
        if (isBalanced()) {
            return "OPTIMAL - Maintenance fertilizer only";
        }
        StringBuilder deficientNutrients = new StringBuilder();
        StringBuilder excessNutrients = new StringBuilder();

        checkNutrientLevel("Nitrogen", nitrogenLevel, deficientNutrients, excessNutrients);
        checkNutrientLevel("Phosphorus", phosphorusLevel, deficientNutrients, excessNutrients);
        checkNutrientLevel("Potassium", potassiumLevel, deficientNutrients, excessNutrients);

        if (deficientNutrients.length() > 0) {
            return "DEFICIENT - High application needed for " + deficientNutrients.toString().trim();
        } else {
            return "EXCESS - Reduce " + excessNutrients.toString().trim() + " application";
        }
    }

    private void checkNutrientLevel(String nutrient, double level, 
                                  StringBuilder deficient, StringBuilder excess) {
        if (level < 20) {
            if (deficient.length() > 0) deficient.append(" ");
            deficient.append(nutrient);
        } else if (level > 100) {
            if (excess.length() > 0) excess.append(" ");
            excess.append(nutrient);
        }
    }
}