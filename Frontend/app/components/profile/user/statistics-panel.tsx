interface StatisticsPanelProps {
  title: string;
  stats: number; // ключевое число в статистике
  unit: string; // ключевой символ статистики (%, ₽, шт.)
  unitPosition?: "left" | "right"; // положение ключевого символа
}

export const StatisticsPanel = ({
  title,
  stats,
  unit,
  unitPosition = "right",
}: StatisticsPanelProps) => {
  return (
    <div className="bg-white rounded-xl shadow-lg p-6 flex flex-col items-center justify-center gap-4">
      <h2 className="text-black font-semibold text-lg text-center">{title}</h2>
      <span className="text-4xl font-semibold">
        {unitPosition === "left" ? <span className="mr-1">{unit}</span> : ""}
        <span className="text-dark-accent">
          {Intl.NumberFormat("ru", {
            style: "decimal",
            minimumFractionDigits: 2,
            maximumFractionDigits: 2,
          }).format(stats)}
        </span>
        {unitPosition === "right" ? <span className="ml-1">{unit}</span> : ""}
      </span>
    </div>
  );
};
