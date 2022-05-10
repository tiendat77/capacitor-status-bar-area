export interface StatusBarAreaPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
