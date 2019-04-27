(ns ptv-fares.core
  (:require [ptv-fares.days :refer [used-days]]
            [clojure.string :refer [join]]))

(def fare 5.3)

(def days (range 28 100))

(defn- total-fare [number-of-days]
  (* number-of-days fare))

(defn- per-day-fare [number-of-days]
  (/ (total-fare number-of-days) (used-days number-of-days)))

(defn- fare-table []
  (->> days
       (map (fn [d] [d, fare, (total-fare d), (used-days d), (per-day-fare d)]))))

(def header "myki_pass_days, daily_fare, total_fare, used_days, actual_daily_fare")

(defn -main [& args]
  (doseq [line          (->> (fare-table)
                             (map (fn [row] (join ", " row)))
                             (cons header))]
    (println line)))
