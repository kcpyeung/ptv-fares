(ns ptv-fares.core
  (:require [ptv-fares.days :refer [used-days]]
            [clojure.string :refer [join]]))

(def fare 5.3)

(def days (range 28 100))

(defn- total-fare [number-of-days]
  (* number-of-days fare))

(defn- per-day-fare [number-of-days]
  (/ (total-fare number-of-days) (used-days number-of-days)))

(defn- thrown-away [d]
  (- d (used-days d)))

(defn- wastefulness [d]
  (float (/ (thrown-away d) d)))

(defn- usefulness [d]
  (- 1 (wastefulness d)))

(defn- fare-table []
  (->> days
       (map
        (fn [d]
          [d
           fare
           (used-days d)
           (per-day-fare d)
           (thrown-away d)
           (wastefulness d)
           (usefulness d)
           (total-fare d)]))))

(def header
  "myki_pass_days, daily_fare, used_days, actual_daily_fare, thrown_away, wastefulness, usefulness, total_fare")

(defn -main [& args]
  (doseq [line          (->> (fare-table)
                             (map (fn [row] (join ", " row)))
                             (cons header))]
    (println line)))
