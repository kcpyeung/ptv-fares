(ns ptv-fares.core)

(def days (range 28 366))

(def cost-per-day 5.3)

(defn used-days [paid-days]
  (->> (/ paid-days 7)
       (* 5)))
